/**
 * @화면명: manageMnu.jsp
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 13. 오전 11:47:10
 * @설명: 메뉴 관리
**/
$.jstree.defaults.core.data = false;

$(document).ready(function () {
	selectMnuList()
});	

function test(){
//	jsTree.load_node(data2);
	jsTree.jstree(true).settings.core.data = data2;
	jsTree.jstree(true).refresh();
}

var mnuList;
function selectMnuList(){
    $.ajax({
        url: '/admin/selectMnuList.do',
        type: 'POST',
        data: {},
        contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
        dataType: 'json',
        success: function (result) {
            mnuList = result.OUT_DATA;
            makeJstree();
        }
    });		
}

//js트리 만들기
var jsTree;
function makeJstree(){
	jsTree = $('#jstree').jstree({ 
	  	"core" : {
		    "animation" : 1,
		    "check_callback" : true,
		    "data" : mnuList,
		    "themes" : {
				"dots" : true,
				"ellipsis" : true,
			},
	  	},
	  	"types" : {
			"leaf" : {
				"icon" : "/resources/images/tree-icon/docs.png",
		    },
		    "f-open" : {
		        "icon" : "/resources/images/tree-icon/open_folder.png",
		    },
		    "f-closed" : {
		        "icon" : "/resources/images/tree-icon/close_folder.png",
		    },	 		  
		    "default" : {
				"icon" : "/resources/images/tree-icon/folder_tree_arrow2.png",
		    },
		},
		"plugins" : ["contextmenu", "dnd", "search", "state", "types", "wholerow"],
	});

	jsTree.on('select_node.jstree', function (event, data) {
//	    console.log(data)
	});
	
	// 트리 열 때 아이콘 세팅
	jsTree.on('open_node.jstree', function (event, data) {
	    data.instance.set_type(data.node,'f-open');
	});
	
	// 트리 닫을 때 아이콘 세팅
	jsTree.on('close_node.jstree', function (event, data) {
		if (data.node.original.mnuLv == 1) {	
			data.instance.set_type(data.node,'f-closed');
		} else {
			data.instance.set_type(data.node,'leaf');
		}
	});	
	
	jsTree.on('ready.jstree', function (event, data) {
	    jsTree.jstree(true).open_all();
	});	
}
