/**
* @author Barret Lee
* @email barret.china@gmail.com
* @date 2013/12/29
*/

/*================================
*              Event
==================================*/
var Event = {};
Event.events = [];
Event.on = function(evt, func){
	for(var i = 0; i < Event.events.length; i++){
		if(Event.events[i].evt == evt){
			Event.events[i].func.push(func);
			return;
		}
	}

	Event.events.push({
		evt: evt,
		func: [func]
	});
};
Event.trigger = function(evt){
	for(var i = 0; i < Event.events.length; i++){
		if(Event.events[i].evt == evt){
			for(var j = 0; j < Event.events[i].func.length; j++){
				Event.events[i].func[j]();
			}
			return;
		}
	}
};
Event.off = function(evt){
	for(var i = 0; i < Event.events.length; i++){
		Event.events.splice(i, 1);
	}		
};


/*================================
*              Utils
==================================*/
Object.keys = Object.keys || function(obj){
　　  var a = [];
　　  for(a[a.length] in obj);
　　  return a ;
}


/*================================
*              require
==================================*/
var r = /require\(\s*"(.*)"\s*\)/g;
var cache = {};
var relation = [];
var obj = {};
function start(str){
	while(match = r.exec(str)){
		obj[match[1]] = new XMLHttpRequest();
		require(obj[match[1]], match[1]);
	}
}

var require = function(xhr, path){

    relation.push(path);

	xhr.open("GET", path, true);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var res = xhr.responseText;
			cache[path] = res;
			console.log("已缓存： " + path);

			delete obj[path];

			Object.keys(obj).length == 0 ? Event.trigger("allLoad") : void 0;
			while(match = r.exec(res)){
				obj[match[1]] = new XMLHttpRequest();
				require(obj[match[1]], match[1]);
			}
		}
	}
	xhr.send();
};


Event.on("allLoad", function(){
	console.log("%c所有模块加载完毕！", "color:red;");
	console.log("%ccache: ", "color:red;");
	console.log(cache);
	console.log("%crelation: ", "color:red;");
	console.log("%c" + relation.join(" → "), "color:green");
})
