$(function () {
    // 콜솔 로그나 얼럿은 세미콜론을 쓰지 않는다. 

    // 도큐먼트 클릭시 콜백함수(이벤트)가 실행되는데
    // 파라미터(인자,매개변수) - 함수 선언부
    // 이벤트 함수의 첫번째 인자는 event 함수다(파라미터명은 상관없다, 근데보통 e, evnet를 쓴다)
    $(document).on("click", function(e) {
        
        if(e.target.className != 'img') {
            $('.popup').hide();
        }

        // console.log(e.target.className)
        // 이벤트(여기서는 클릭) 타겟 클래스네임을 알아야
        // 클릭한 타깃의 클래스네임을 찾기 위해
        // var className = e.target.className;
        // if(className == 'img') {
        //     // console.log(1)
        //     $(".popup").show();
        // } else if(className == 'close') {
        //     // console.log(2)
        //     $(".popup").hide();
        // } else {
        //     // console.log(3)
        //     $(".popup").hide();
        // }
    });

    // 함수 실행시는 인수(아규먼트)라고 한다.
    // dkf(dlsk);

    // $(".close").click(function () {
    //     $(".popup").hide();
    // });

});
