layui.use(['element'], function(){
	$ = layui.jquery;
  	var element = layui.element; 
  
    // 导航的hover效果、二级菜单等功能，需要依赖element模块
    // larry-side-menu向左折叠
    // 这里先不区分分辨率了，始终默认显示sidebar
  	var sidebarShow = true;
  	if ($(window).width() < 750) {
  		sidebarShow = true;
	} else {
		sidebarShow = true;
	}
	
  	$('.larry-side-menu').click(function() {
  		if (sidebarShow) {
  			$('.x-side').animate({left: '-200px'},200).siblings('.x-main').animate({left: '0px'},200);
  			sidebarShow = false;
  		} else {
  			$('.x-side').animate({left: '0px'},200).siblings('.x-main').animate({left: '200px'},200);
  			sidebarShow = true;
  		}
  	});

  	// 监听导航点击
  	element.on('nav(side)', function(elem) {
    	var title = elem.find('cite').text();
    	var url = this.getAttribute('_href');
    	if (!url) {
    		return false
    	}
    	url='/admin/' + url
//    	console.log(url);

    	for (var i = 0; i < $('.x-iframe').length; i++) {
    		if ($('.x-iframe').eq(i).attr('src') === url) {
    			element.tabChange('x-tab', url);
    			return;
    		}
    	};

    	element.tabAdd('x-tab', {
    		title: title    // 用于演示
    		,content: '<iframe frameborder="0" src="'+url+'" class="x-iframe"></iframe>'
    		,id: url
    	});

		element.tabChange('x-tab', url);

  	});
});


