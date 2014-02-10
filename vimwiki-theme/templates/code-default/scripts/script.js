var hlCodePath = 'hl-code/scripts/';
var hlCodePath = '../../vimwiki-theme/3rd-libs/hightlight-code/scripts/';

/**
 * 各语言高亮脚本的路径
 */
function path() {
	var args = arguments, result = [];
	for(var i = 0; i < args.length; i++) {
		result.push(args[i].replace('@', hlCodePath ));
	}
	return result;
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
					)
					);
	SyntaxHighlighter.all();
};

/**
 * 调整目录的大小
 */
var padding = 5;
function changeTocSize() {
	var height = document.documentElement.clientHeight - 150;
	$("div.toc").height(height);
	$("div.tocWrap").css('padding', padding + 'px');
};

/**
 * 打开、收起所有目录
 */
function openAll() {
	$('div.toc    ul').removeClass('ul-index-close');
	$('div.toc    ul').addClass('ul-index-open');
	$('div.toc>ul ul').show(300);
};
function closeAll() {
	$('div.toc    ul').removeClass('ul-index-open');
	$('div.toc    ul').addClass('ul-index-close');
	$('div.toc>ul ul').hide(300);
};

$(document).ready(function() {
	loadCodeHightlight(); // 启用语法高亮

	// 目录的内容
	var idxCtx = '<a href="javascript:openAll();">展开</a>&nbsp;<a href="javascript:closeAll();">收起</a>';
	idxCtx = idxCtx + $('.toc').html();
	$('.toc').remove();
	// 目录内容区
	var idxBody = '<div class="toc">' + idxCtx + '</div>';
	// 目录标题
	var idxTitle = '<div class="toggler" title="点击展开/收起，Shift+Z 隐藏或打开">目录</div>';
	// 目录全部
	var idxAll = '<div class="tocWrap">' + idxTitle + idxBody + '</div>';

	/* 添加到内容中 */
	$('.note-main').append(idxAll);
	var toggler = $('.toggler');
	var tocWrap = $('.tocWrap');
	changeTocSize();         // 调整目录大小
	openAll();               // 展开目录
	$('div.toggler').click(function() { $('div.toc').toggle(); }); // 开关目录事件
	$('div.tocWrap').show(); // 显示目录

	/* jquery淡出效果 */
	if (false) { // 只有jQuery生效
		tocWrap.prepend(toggler).delay(500).fadeTo(500, '0.25').hover(
				function() { $(this).stop().fadeTo(300, '0.9'); },
				function() { $(this).stop().fadeTo(300, '0.25'); }
		);
	}
});

