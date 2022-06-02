function getRandomInt(max) {
    max + 1;
    return Math.floor(Math.random() * max) + 1;
}


function showOnlynoneBookedRooms() {


    //users search dates
    let userStartDate = localStorage.getItem("UserStartDate");
    let userEndDate = localStorage.getItem("UserEndDate");
    console.log(userStartDate)
    //bookings dates
    let startDate;
    let endDate;
    let bookingYearStart;
    let bookingYearEnd;
    let bookingMonthStart;
    let bookingMonthEnd;
    let bookingDayStart;
    let bookingDayEnd;
    var arrayNonBookedRooms = [];
    $.get("../../HotelOverLookJavaFX/src/main/resources/bookings.xml",
        function (xml, status) {
            Array.from($(xml).find("booking")).forEach((booking) => {

                bookingYearStart = booking.childNodes[5].childNodes[1].childNodes[5].textContent;
                bookingMonthStart = booking.childNodes[5].childNodes[1].childNodes[3].textContent - 1;
                bookingDayStart = booking.childNodes[5].childNodes[1].childNodes[1].textContent;
                startDate = new Date(bookingYearStart, bookingMonthStart, bookingDayStart, 2, 0, 0, 0);


                bookingYearEnd = booking.childNodes[5].childNodes[3].childNodes[5].textContent;
                bookingMonthEnd = booking.childNodes[5].childNodes[3].childNodes[3].textContent - 1;
                bookingDayEnd = booking.childNodes[5].childNodes[3].childNodes[1].textContent;
                endDate = new Date(bookingYearEnd, bookingMonthEnd, bookingDayEnd, 2, 0, 0, 0);
                //console.log(endDate);

                if (overlappingDates(startDate, endDate, userStartDate, userEndDate)) {
                    console.log(booking.childNodes[7].childNodes[1].textContent)
                    arrayNonBookedRooms.push(booking.childNodes[7].childNodes[1].textContent)
                }

            });

        }
    );

    $.get(
        "../../HotelOverLookJavaFX/src/main/resources/rooms.xml",
        function (xml, status) {
            var roomTitle = "";
            var beds = "";
            var guestAmount = "";
            var number = "";
            var price = "";
            var extras = "";
            var div = " <div class='row pt-5'>";
            var arrayAllRoomsdRooms = [];
           
            //for (var index = 0; index < arrayNonBookedRooms.length; index++) {
                Array.from($(xml).find("room")).forEach((rooms) => {

                    arrayAllRoomsdRooms.push(rooms);
                
                });
               
                for(var c=0;c<arrayAllRoomsdRooms.length;c++){
                    for(var d=0;d<arrayNonBookedRooms.length;d++){
              
                    if(arrayNonBookedRooms[d]==arrayAllRoomsdRooms[c].childNodes[1].textContent){
                        arrayAllRoomsdRooms.splice(c, 1);
                    }
                    }
                }
                for(var e=0;e<arrayAllRoomsdRooms.length;e++){
                  console.log("allllllll-> "+arrayAllRoomsdRooms[e].childNodes[1].textContent);
                    beds = arrayAllRoomsdRooms[e].childNodes[9].textContent;
                    guestAmount = arrayAllRoomsdRooms[e].childNodes[5].textContent;
                    number = "Room " + arrayAllRoomsdRooms[e].childNodes[1].textContent;
                    price = arrayAllRoomsdRooms[e].childNodes[3].textContent;
                    extras = arrayAllRoomsdRooms[e].childNodes[11].textContent;
                    div += " <div class='col-xl-6'><p class='text-center text-blue font-SansSerifBldFLFCond h2'>" + number + "</p><p class='text-center h4 mt-4'>" + roomTitle + "</p><p class='text-center h4'>Historyc suits with a cassic look</p><img class='mx-auto d-block rounded' src='./images/rooms/roomsRandom/" + getRandomInt(17) + ".jpg' alt='Room'title='Room' width='90%'><div class='d-flex'><p class='text-blue marginLeft25 h3'><a href='./roomInformation.html'onclick='roomGlobal(" + number + ")'>DETAILS >></a></p> <a href='./contactUs.html#booked' class='text-blue marginLeftRight h3'> BOOK >></a> </div></div>";
                    $("#roomtotal").html(div);
                }
            //}
            console.log(arrayAllRoomsdRooms[0].childNodes[1].textContent)
            div += "</div>";
        }
    );
}


//check if dates are overlapingg

function overlappingDates(StartDate1, EndDate1, StartDate2, EndDate2) {
    if ((Date.parse(StartDate2) <= Date.parse(EndDate1)) && (Date.parse(StartDate1) <= Date.parse(EndDate2))) {
        console.log("are overlaping");
        return true; 
    } else {
        console.log("are not overlaping");
        return false;
    }
}


function getAllRooms() {
    $.get(
        "../../HotelOverLookJavaFX/src/main/resources/rooms.xml",
        function (xml, status) {
            var roomTitle = "";
            var beds = "";
            var guestAmount = "";
            var number = "";
            var price = "";
            var extras = "";
            var div = " <div class='row pt-5'>";
            Array.from($(xml).find("room")).forEach((rooms) => {
                roomTitle = rooms.childNodes[7].textContent;
                //1 -> room number
                //3 -> room price
                //5 -> room guests
                //7 -> room type
                //9 -> bed type
                //11 -> extras
                beds = rooms.childNodes[9].textContent;
                guestAmount = rooms.childNodes[5].textContent;
                number = "Room " + rooms.childNodes[1].textContent;
                price = rooms.childNodes[3].textContent;
                extras = rooms.childNodes[11].textContent;
                div += " <div class='col-xl-6'><p class='text-center text-blue font-SansSerifBldFLFCond h2'>" + number + "</p><p class='text-center h4 mt-4'>" + roomTitle + "</p><p class='text-center h4'>Historyc suits with a cassic look</p><img class='mx-auto d-block rounded' src='./images/rooms/roomsRandom/" + getRandomInt(17) + ".jpg' alt='Room'title='Room' width='90%'><div class='d-flex'><p class='text-blue marginLeft25 h3'><a href='./roomInformation.html'onclick='roomGlobal(" + rooms.childNodes[1].textContent + ")'>DETAILS >></a></p> <a href='./contactUs.html#booked' class='text-blue marginLeftRight h3'> BOOK >></a> </div></div>";
                $("#roomtotal").html(div);
            });
            div += "</div>";
        }
    );
}

function getRoomByNumber(roomNumber) {
    $.get(
        "../../HotelOverLookJavaFX/src/main/resources/rooms.xml",
        function (xml, status) {
            var roomTitle = "";
            var beds = "";
            var guestAmount = "";
            var number = "";
            var price = "";
            var extras = "";
            var div = " <div class='row pt-5'>";
            Array.from($(xml).find("room")).forEach((rooms) => {
                if (roomNumber == rooms.childNodes[1].textContent) {
                    roomTitle = rooms.childNodes[7].textContent;
                    //1 -> room number
                    //3 -> room price
                    //5 -> room guests
                    //7 -> room type
                    //9 -> bed type
                    //11 -> extras
                    beds = rooms.childNodes[9].textContent;
                    guestAmount = rooms.childNodes[5].textContent;
                    number = "Room " + rooms.childNodes[1].textContent;
                    price = rooms.childNodes[3].textContent;
                    extras = rooms.childNodes[11].textContent;
                    div += " <div class='col-xl-6'><p class='text-center text-blue font-SansSerifBldFLFCond h2'>" + number + "</p><p class='text-center h4 mt-4'>" + roomTitle + "</p><p class='text-center h4'>Historyc suits with a cassic look</p><img class='mx-auto d-block rounded' src='./images/rooms/roomsRandom/" + getRandomInt(17) + ".jpg' alt='Room'title='Room' width='90%'><div class='d-flex'><p class='text-blue marginLeft25 h3'><a href='./roomInformation.html'onclick='roomGlobal(" + rooms.childNodes[1].textContent + ")'>DETAILS >></a></p> <a href='./contactUs.html#booked' class='text-blue marginLeftRight h3'> BOOK >></a> </div></div>";
                    $("#roomtotal").html(div);
                }
            });
            div += "</div>";


        }
    );
}


function getRoomImages() {
    NUMBEROFIMAGES = 3;
    var div = "<div class='carousel-inner'>";
    for (var a = 0; a < NUMBEROFIMAGES; a++) {
        if (a == 1) {
            div += " <div class='carousel-item active' data-bs-interval='20000'><img src='./images/rooms/roomsRandom/" + getRandomInt(17) + ".jpg' class='d-block w-100 rounded' height='10%' alt='roomImage'><button class='carousel-control-prev' type='button' data-bs-target='#carouselExampleInterval1' data-bs-slide='prev'><span class='carousel-control-prev-icon' aria-hidden='true'></span><span class='visually-hidden'>Previous</span></button><button class='carousel-control-next' type='button' data-bs-target='#carouselExampleInterval1' data-bs-slide='next'><span class='carousel-control-next-icon' aria-hidden='true'></span><span class='visually-hidden'>Next</span></button> </div>";
        } else {
            div += " <div class='carousel-item' data-bs-interval='20000'><img src='./images/rooms/roomsRandom/" + getRandomInt(17) + ".jpg' class='d-block w-100 rounded' height='10%' alt='roomImage'><button class='carousel-control-prev' type='button' data-bs-target='#carouselExampleInterval1' data-bs-slide='prev'><span class='carousel-control-prev-icon' aria-hidden='true'></span><span class='visually-hidden'>Previous</span></button><button class='carousel-control-next' type='button' data-bs-target='#carouselExampleInterval1' data-bs-slide='next'><span class='carousel-control-next-icon' aria-hidden='true'></span><span class='visually-hidden'>Next</span></button> </div>";
        }
        $("#imagesCarousel").html(div);

    }
    div += "</div>";
}

function room(room) {
    $.get(
        "../../HotelOverLookJavaFX/src/main/resources/rooms.xml",
        function (xml, status) {
            var roomTitle = "";
            var beds = "";
            var guestAmount = "";
            var number = "";
            var price = "";
            var extras = "";

            Array.from($(xml).find("room")).forEach((rooms) => {
                if (room == rooms.childNodes[1].textContent) {
                    console.log(rooms.childNodes[9].textContent)
                    roomTitle += rooms.childNodes[7].textContent;
                    beds += rooms.childNodes[9].textContent;
                    guestAmount += rooms.childNodes[5].textContent;
                    number += rooms.childNodes[1].textContent;
                    price += rooms.childNodes[3].textContent;
                    extras += rooms.childNodes[11].textContent;
                }
            });

            $("#roomTitle").html(roomTitle);
            $("#beds").html(beds);
            $("#guestAmount").html(guestAmount);
            $("#number").html(number);
            $("#price").html(price);
            $("#extras").html(extras);
        }
    );
}
room(localStorage.getItem("roomNumber"))
