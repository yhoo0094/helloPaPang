/**
 * @화면명: manageMnu.jsp
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 13. 오전 11:47:10
 * @설명: 메뉴 관리
**/

$(document).ready(function () {
	selectMnuList()
});	

var data = [
		       { "id" : "ajson1", "parent" : "#", "text" : "Simple root node" },
		       { "id" : "ajson2", "parent" : "#", "text" : "Root node 2" },
		       { "id" : "ajson3", "parent" : "ajson2", "text" : "Child 1" },
		       { "id" : "ajson4", "parent" : "ajson2", "text" : "Child 2" },
		   ];
		   
var data2 = [
		       { "id" : "ajson1", "parent" : "#", "text" : "AAA" },
		       { "id" : "ajson2", "parent" : "#", "text" : "BBB" },
		       { "id" : "ajson3", "parent" : "ajson2", "text" : "CCC" },
		       { "id" : "ajson4", "parent" : "ajson2", "text" : "DDD" },
		   ];		   

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
	    "animation" : 0,
	    "check_callback" : true,
	    "themes" : { "stripes" : true },
	    "data" : mnuList,
  	},
  	"types" : {
	    "#" : {
			"icon" : "/resources/images/tree-icon/next.png",
	    },
	    "root" : {
	    	"icon" : "/resources/images/tree-icon/next.png",
	    },
	    "default" : {
			"icon" : "/resources/images/tree-icon/next.png",
	    },
	    "file" : {
	    	"icon" : "/resources/images/tree-icon/next.png",
	    }
	},
	"plugins" : ["contextmenu", "dnd", "search", "state", "types", "wholerow"] 
	});
}
