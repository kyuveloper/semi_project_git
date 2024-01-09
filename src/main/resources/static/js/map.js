document.addEventListener('DOMContentLoaded', initMap);
function getCurrentLocation() {
    return new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(
            position => {
                resolve(position);
            },
            error => {
                reject(error);
            }
        )
    })
}
async function initMap() {
    await fetchMap();
}
async function fetchMap() {
    try {
        // 위치
        const position = await getCurrentLocation();
        let latitude = position.coords.latitude;
        let longitude = position.coords.longitude;

        const data = await fetch(`http://localhost:8083/api/map`) // java에서 업체 정보 받아오는 api 호출
            .then(result => result.json());
        console.log('data:: ', data)

        const areaArr = [];
        data.forEach(item => {
            areaArr.push(
                {
                    code: `${item.companyCode}`,
                    information: `${item.companyName}`,
                    address: `${item.companyAddress}`,
                    lat: `${item.companyLat}`,
                    lng: `${item.companyHar}`,
                    phone: `${item.companyPhone}`,
                    time: `${item.companyTime}`,
                    url: `${item.companyUrl}`
                }
            )
        })

        let markers = []; // 마커 정보를 담는 배열
        let infoWindows = []; // 정보창을 담는 배열

        //지도 시작 지점
        var map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(latitude, longitude),
            zoom: 13,
            mapTypeControl: true
        });

        for (var i = 0; i < areaArr.length; i++) {
            // 지역을 담은 배열의 길이만큼 for문으로 마커와 정보창을 채워주자

            var marker = new naver.maps.Marker({
                map: map,
                title: areaArr[i].information, // 지역구 이름
                position: new naver.maps.LatLng(areaArr[i].lat , areaArr[i].lng) // 지역구의 위도 경도 넣기
            });

            /* 정보창 */
            var infoWindow = new naver.maps.InfoWindow({
                content: '<div style="width:250px;text-align:center;padding:10px;">'+ '<' + areaArr[i].information + '>' + '<br>' + '주소 : ' + areaArr[i].address + '<br>' + '전화번호 : ' + areaArr[i].phone + '<br>' + '영업시간 : ' + areaArr[i].time + '<br>' + '<a href="'+areaArr[i].url+'" target="_blank">업체 사이트 방문</a>' + '<br> - 펫테일 - </div>'
            }); // 클릭했을 때 띄워줄 정보 HTML 작성

            markers.push(marker); // 생성한 마커를 배열에 담는다.
            infoWindows.push(infoWindow); // 생성한 정보창을 배열에 담는다.
        }

        function getClickHandler(seq) {

            return function (e) {  // 마커를 클릭하는 부분
                var marker = markers[seq], // 클릭한 마커의 시퀀스로 찾는다.
                    infoWindow = infoWindows[seq]; // 클릭한 마커의 시퀀스로 찾는다

                if (infoWindow.getMap()) {
                    infoWindow.close();
                } else {
                    infoWindow.open(map, marker); // 표출
                }
            }
        }
        for (var i=0, ii=markers.length; i<ii; i++) {
            naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i)); // 클릭한 마커 핸들러
        }

        /* (좌측상단 버튼) 내위치로 지도 이동 */
        var locationBtnHtml = '<a href="#" class="mapBtn"><span class="mapBtnText">내 위치로</span></a>';

        var customControl = new naver.maps.CustomControl(locationBtnHtml, {
            position: naver.maps.Position.TOP_LEFT
        });

        naver.maps.Event.once(map, 'init', function() {
            customControl.setMap(map);

            naver.maps.Event.addDOMListener(customControl.getElement(), 'click', function() {
                map.setCenter(new naver.maps.LatLng(latitude, longitude));
                map.setZoom(13)
            });
        });
    } catch (error) {
        console.error('Error fetching map data:', error);
    }
}