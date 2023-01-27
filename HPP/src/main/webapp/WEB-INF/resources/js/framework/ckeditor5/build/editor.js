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
		, toolbar: {
				items: [ 
					'fontSize', 'fontColor', 'fontBackgroundColor', 'fontFamily', 'alignment', '|',
					'bold', 'italic', 'underline', '|',	
					'highlight', 'outdent', 'indent', '|',
					'imageUpload', 'insertTable', 'undo', 'redo', 'findAndReplace',
					//'-', 'specialCharacters', 'imageInsert', 'heading', 'style'
				],
				shouldNotGroupWhenFull: true
		}     
		, language: 'ko' 
		, image: {
			toolbar: [
				'imageTextAlternative',
				'toggleImageCaption',
				'imageStyle:inline',
				'imageStyle:block',
				'imageStyle:side',
				//'linkImage'
			]
		}
		, table: {
			contentToolbar: [
				'tableColumn',
				'tableRow',
				'mergeTableCells',
				'tableCellProperties',
				'tableProperties'
			]
		}        
    })

}

function MyCustomUploadAdapterPlugin(editor) {
    editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
        return new UploadAdapter(loader)
    }
}	