$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});

$(function() {
    // 출발일은 오늘 이상만 선택 가능
    $("#startDate").datepicker({
        minDate: 0
    });

    // 도착일은 출발일 이상만 선택 가능
    $("#endDate").datepicker({
        minDate: 0
    });
})

function calculateDays() {
    // 출발일과 도착일 입력값 가져오기
    var startDateStr = $("#startDate").val();
    var endDateStr = $("#endDate").val();

    // Date 객체로 변환
    var startDate = new Date(startDateStr);
    var endDate = new Date(endDateStr);

    // 두 날짜 간의 차이 계산 (밀리초로 반환)
    var timeDiff = endDate - startDate;

    // 일수로 변환 (밀리초 -> 초 -> 분 -> 시간 -> 일)
    var daysDiff = Math.floor(timeDiff / (1000 * 60 * 60 * 24) + 1);

    // 결과 표시
    $("#result").text("출발일과 도착일 사이의 일수: " + daysDiff + "일");
}