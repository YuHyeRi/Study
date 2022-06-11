$(function() {
    alert('test'); // 테스트용

    var body = '#wrap > .container > div > div';

    $(body).mouseenter(function () { 
        console.log('open');    // 테스트용
        $(this).find('.img').show();
    });
    $(body).mouseleave(function () {
        console.log('close');   // 테스트용
        $(this).find('.img').hide();
    });
})