/**
 * 
 */
(function (){
	 //配置信息
	 //layout
	 var layoutSettings={
		   parent: document.body,
		   pattern: "2U",
		   cells:[
				{id: "a",text:"navigation1",width: 100, header: true, fix_size: [true, false]},
				{id: "b",text:"navigation2",header: true, fix_size: [true, false]}, 
		   ],
		   offsets:{
			   top:0,
			   right:0,
			   left:0,
			   bottom:0
		   },
		   skin: "",
		   url: "#"
	 };
	 //layoutcell
	 var layoutcellSettings={
		 id: "a"
		 ,text:"navigation1",
		 width: 100
		 , header: true, 
		 fix_size: [true, false]
	 };

	 
	 //accordion 
	 var accordionSettings={
		    parent:document.body,
		    icons_path:"",
		    skin:"",
		    multi_mode:false,  //是否是多模块模式
		    dnd:false,  //是否可拖拽
		    items:[]
	 };
	 //Tree
	 var treeSettings={
			    parent: document.body,
				checkbox: true,
				image_path: "",
				xml: "" 
	 }
	 //TabBar
	 var tabBarSettings={
		     	parent:             document.body,    // id/object, container for tabbar 
			    skin:               "",  // string, tabbar skin, optional
			    mode:               "top",          // string, top or bottom tabs mode, optional
			    align:              "left",         // string, left or right tabs align, optional
			    close_button:       true,           // boolean, render closing button on tabs, optional
			    content_zone:       true,           // boolean, enable/disable content zone, optional
			    xml:                "",   // string, path to xml config, optional
			    json:               "",  // string, path to json config, optional
			    onload:             function(){},   // function, callback for xml/json, optional
			    arrows_mode:        "auto"  ,        // mode of showing tabs arrows (auto, always)			 
			    tabs: [ // tabs config			 
			    	tabSettings	 
			    ]
	  }
	 //tabbar 子分区,tab
	  var tabSettings= {
	            id:      "a1",      // tab id
	            text:    "Text",    // tab text
	            width:   null,      // numeric for tab width or null for auto, optional
	            index:   null,      // numeric for tab index or null for last position, optional
	            active:  true,      // boolean, make tab active after adding, optional
	            enabled: false,     // boolean, false to disable tab on init
	            close:   true       // boolean, render close button on tab, optional
	  }		
	 //grid 
	 var gridSettings={
				image_path:"",
				columns:[
					
			    ],
				multiselect:true,
				xml:""		 
	  }
	 //gridcell
	 var  gridCellSettings={
				label:"Column A",
				width:100,
				type:"ro",
				sort:"int",
				align:"right"				
     }
       
	 /**
	  * 1.初始化控件，
	  * 2.关联相关控件，
	  * 3.加载数据，
	  * 4.注册事件
	  * 例- layout 2-> toolbar ->3 ,
	  *            -> tabbar -> 2 ->grid->3，  ->4
	  *            ->accordion->2->tree->3,
	  */
	 
	 DhtmlxPlugin=function (){
		   
	 };
	 DhtmlxPlugin.prototype={
	     initLayout:function(options){
	    	   var layout=new dhtmlXLayoutObject(options);
	    	   return layout;
	     }     
	 }
	 
     window.dhtmlxPlugin=new DhtmlxPlugin();	 
})();