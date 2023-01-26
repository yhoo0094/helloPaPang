/**
* @파일명: editor.js
* @작성자: KimSangMin
* @생성일: 2023. 1. 26. 오후 5:52:16
* @설명: CK에디터 파일 업로드 모듈
*/

import UploadAdapter from './UploadAdapter.js'

export default function makeEditor(target) {
    return InlineEditor.create(document.querySelector(target), {
        extraPlugins: [MyCustomUploadAdapterPlugin]
    })

}

function MyCustomUploadAdapterPlugin(editor) {
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
        return new UploadAdapter(loader)
    }
}	