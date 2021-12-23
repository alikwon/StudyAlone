function bookHotel(city) {
    var availableHotel = "None";
    for (var i = 0; i < hotels.length; i++) {
        var hotel = hotels[i];
        if (hotel.city === city && hotel.hasRoom) {
            availableHotel = hotel.name;
            break;
        }
    }

    //i 와 hotel 접근가능
    console.log("체크 " + (i + 1) + " recode(s)");
    console.log("Last 체크 " + hotel.name);

    { //중첩된 함수 closer
        function placeOrder() {
            var totalAmount = 200;
            console.log("Order Placed to " + availableHotel);
        }
    }

    placeOrder();

    //접근불가
    // console.log(totalAmount);

    return availableHotel;
}

var hotels = [
    { name: "Hotel A", hasRoom: false, city: "서울" },
    { name: "Hotel B", hasRoom: true, city: "서울" },
];
console.log(bookHotel('서울'));

//접근불가
// console.log(availableHotel);
