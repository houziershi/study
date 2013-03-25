function path() {
  var args = arguments,
      result = []
      ;
       
  for(var i = 0; i < args.length; i++)
      result.push(args[i].replace('@', 'hl-code/scripts/'));
       
  return result
};

function loadCodeHightlight(){
	SyntaxHighlighter.autoloader.apply(null, path(
		'applescript            @shBrushAppleScript.js',
		'actionscript3 as3      @shBrushAS3.js',
		'bash shell             @shBrushBash.js',
		'coldfusion cf          @shBrushColdFusion.js',
		'cpp c                  @shBrushCpp.js',
		'c# c-sharp csharp      @shBrushCSharp.js',
		'css                    @shBrushCss.js',
		'delphi pascal          @shBrushDelphi.js',
		'diff patch pas         @shBrushDiff.js',
		'erl erlang             @shBrushErlang.js',
		'groovy                 @shBrushGroovy.js',
		'java                   @shBrushJava.js',
		'jfx javafx             @shBrushJavaFX.js',
		'js jscript javascript  @shBrushJScript.js',
		'perl pl                @shBrushPerl.js',
		'php                    @shBrushPhp.js',
		'text plain             @shBrushPlain.js',
		'py python              @shBrushPython.js',
		'ruby rails ror rb      @shBrushRuby.js',
		'sass scss              @shBrushSass.js',
		'scala                  @shBrushScala.js',
		'sql                    @shBrushSql.js',
		'vb vbnet               @shBrushVb.js',
		'xml xhtml xslt html    @shBrushXml.js'
	));
	SyntaxHighlighter.all();
}

$(document).ready(function() {
    if (window.innerWidth >= 480) {
        var toggler = $('<div class="toggler" title="点击展开/收起，Shift+Z 隐藏或打开">目录</div>'),
        toc = $('.toc');
        toc.wrap('<div class="tocWrap">');

        $('.tocWrap').prepend(toggler)
        .delay(500)
        .fadeTo(500, '0.25')
        .hover(function() {
            $(this).stop().fadeTo(300, '0.9');
        }, function() {
            $(this).stop().fadeTo(300, '0.25');
        });

        $('html').keypress(function(e) {
            if (e.shiftKey && (e.charCode || e.keyCode) == '90') {
                e.preventDefault();
                $('div.tocWrap').toggle(200);
            }
        });

        toggler.click(function() {
            $('div.toc').slideToggle(300);
        });
    };

	//SyntaxHighlighter.autoloader(
	//'js jscript javascript  scripts/shBrushJScript.js',
    //'bash shell             scripts/shBrushBash.js',
	//'xml xhtml xslt html    scripts/shBrushXml.js'
	//);
	//
	loadCodeHightlight();
});
