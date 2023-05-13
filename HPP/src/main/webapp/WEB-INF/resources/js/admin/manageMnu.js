/**
 * @화면명: manageMnu.jsp
 * @작성자: KimSangMin
 * @생성일: 2023. 5. 13. 오전 11:47:10
 * @설명: 메뉴 관리
**/

$(document).ready(function () {
	makeJstree();
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

//js트리 만들기
var jsTree;
function makeJstree(){
		jsTree = $('#jstree').jstree({ 
  "core" : {
    "animation" : 0,
    "check_callback" : true,
    "themes" : { "stripes" : true },
    'data' : data,
//       "url" : "/some/path",
//      "data" : function (nodes) {
//        return { "ids" : nodes.join(",") };
//      }   
    
  },
  "types" : {
    "#" : {
      "max_children" : 1,
      "max_depth" : 4,
      "valid_children" : ["root"]
    },
    "root" : {
      "icon" : "/static/3.3.15/assets/images/tree_icon.png",
      "valid_children" : ["default"]
    },
    "default" : {
      "valid_children" : ["default","file"]
    },
    "file" : {
      "icon" : "glyphicon glyphicon-file",
      "valid_children" : []
    }
  },
  "plugins" : [
    "contextmenu", "dnd", "search",
    "state", "types", "wholerow"
  ]    
	    });
}
