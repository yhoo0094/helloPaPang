/**
* @작성자: KimSangMin
* @생성일: 2023. 1. 26. 오후 5:47:15
* @설명: CK에디터 유틸
 */
var $editorUtil = {};

$editorUtil.createEditorTest = function(){
	editor(".editor").then(editor => {
        	alert('adfadf');
        	// some code..
            // then 이후에 받은 editor를 다른 변수로 받아주시는 편이 좋습니다!
        })
}

/**
 * 에디터 생성하기
 */
$editorUtil.createEditor = function(){
	
	InlineEditor.defaultConfig = {
		toolbar: {
			items: [
				'fontSize',
				'fontColor',
				'fontBackgroundColor',
				'fontFamily',
				'alignment',
				'|',
				'bold',
				'italic',
				'underline',
				'|',				
				'highlight',
				'outdent',
				'indent',
				'|',
				'imageUpload',
				'insertTable',
				'undo',
				'redo',
				'findAndReplace',
				
				//'-',
				//'specialCharacters',
				//'imageInsert',
				//'heading',
				//'style'
			],
			shouldNotGroupWhenFull: true
		},
		language: 'ko',
		image: {
			toolbar: [
				'imageTextAlternative',
				'toggleImageCaption',
				'imageStyle:inline',
				'imageStyle:block',
				'imageStyle:side',
				'linkImage'
			]
		},
		table: {
			contentToolbar: [
				'tableColumn',
				'tableRow',
				'mergeTableCells',
				'tableCellProperties',
				'tableProperties'
			]
		}
	};	
	
	InlineEditor.create( document.querySelector('.editor'),{
					//plugins: [ SimpleUploadAdapter]
			        simpleUpload: {
			            // The URL that the images are uploaded to.
			            uploadUrl: '/common/ckUploadImage.do',
			
			            // Enable the XMLHttpRequest.withCredentials property.
			            withCredentials: true,
			
			            // Headers sent along with the XMLHttpRequest to the upload server.
			            headers: {
			                'X-CSRF-TOKEN': 'CSRF-Token',
			                Authorization: 'Bearer <JSON Web Token>'
			            }
			        }					
				})
				.then( editor => {
					window.editor = editor;
				} )
				.catch( error => {
					console.error( error );
				} );	
}
