var hlCodePath = 'hl-code/scripts/';
var hlCodePath = '../../vimwiki-theme/hightlight-code/scripts/';

/**
 * 各语言高亮脚本的路径
 */
function path() {
  var args = arguments, result = [] ;
	   
  for(var i = 0; i < args.length; i++)
	  result.push(args[i].replace('@', hlCodePath ));
	   
  return result
};
function loadCodeHightlight(){
	SyntaxHighlighter.autoloader.apply(null, path(
		'applescript			@shBrushAppleScript.js',
		'actionscript3 as3	  @shBrushAS3.js',
		'bash shell			 @shBrushBash.js',
		'coldfusion cf		  @shBrushColdFusion.js',
		'cpp c				  @shBrushCpp.js',
		'c# c-sharp csharp	  @shBrushCSharp.js',
		'css					@shBrushCss.js',
		'delphi pascal		  @shBrushDelphi.js',
		'diff patch pas		 @shBrushDiff.js',
		'erl erlang			 @shBrushErlang.js',
		'groovy				 @shBrushGroovy.js',
		'java				   @shBrushJava.js',
		'jfx javafx			 @shBrushJavaFX.js',
		'js jscript javascript  @shBrushJScript.js',
		'perl pl				@shBrushPerl.js',
		'php					@shBrushPhp.js',
		'text plain			 @shBrushPlain.js',
		'py python			  @shBrushPython.js',
		'ruby rails ror rb	  @shBrushRuby.js',
		'sass scss			  @shBrushSass.js',
		'scala				  @shBrushScala.js',
		'sql					@shBrushSql.js',
		'vb vbnet			   @shBrushVb.js',
		'xml xhtml xslt html	@shBrushXml.js'
	));
	SyntaxHighlighter.all();
};

/**
 * 调整目录的大小
 */
var padding = 5;
function changeTocSize() {
	var height = document.documentElement.clientHeight - 100;
	$(".toc").height(height);
};

/**
 * 打开、收起所有目录
 */
function openAll() {
	$('div.toc    li').removeClass('li-index-close');
	$('div.toc    li').addClass('li-index-open');
	$('div.toc>ul ul').show(300);
};
function closeAll() {
	$('div.toc    li').removeClass('li-index-open');
	$('div.toc    li').addClass('li-index-close');
	$('div.toc>ul ul').hide(300);
};

$(document).ready(function() {
	if (window.innerWidth >= 480) {
		// 目录标题
		var toggerStr = '<div class="toggler" title="点击展开/收起，Shift+Z 隐藏或打开">' 
			+ '目录' + '</div>';
		var toggler = $(toggerStr);
		toggler.click(function() { $('div.toc').slideToggle(300); });

		// 目录
		var toc = $('.toc');
		toc.prepend('<a href="javascript:openAll();">展开</a>&nbsp;'
			+ '<a href="javascript:closeAll();">收起</a>');
		toc.wrap('<div class="tocWrap">');
		$('.tocWrap').prepend(toggler).delay(500).fadeTo(500, '0.25').hover(
			function() {
				$(this).stop().fadeTo(300, '0.9');
			},
			function() {
				$(this).stop().fadeTo(300, '0.25');
			}
		);
		$(".tocWrap").css('padding',padding+'px');

		changeTocSize();

		$('html').keypress(function(e) {
			if (e.shiftKey && (e.charCode || e.keyCode) == '90') {
				e.preventDefault();
				$('div.tocWrap').toggle(200);
			}
		});


		$('div.toc>ul li').removeClass('li-index-close');
		$('div.toc>ul li').addClass('li-index-open');
		$('div.toc>ul ul').show();
	};

	//SyntaxHighlighter.autoloader(
	//'js jscript javascript  scripts/shBrushJScript.js',
	//'bash shell			 scripts/shBrushBash.js',
	//'xml xhtml xslt html	scripts/shBrushXml.js'
	//);
	//

	loadCodeHightlight();
});
