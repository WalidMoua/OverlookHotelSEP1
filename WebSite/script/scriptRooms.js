


function getAllRooms() {
    $.get(
        "/HotelOverLookJavaFX/src/main/resources/rooms.xml",
        function (xml, status) {
            var roomTitle = "";
            var beds = "";
            var guestAmount = "";
            var number = "";
            var price = "";
            var extras = "";
            var div =" <div class='row pt-5'>";
            Array.from($(xml).find("room")).forEach((rooms) => {
               // if (room != rooms.childNodes[1].textContent) {                
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
                    div += " <div class='col-xl-6'><p class='text-center text-blue font-SansSerifBldFLFCond h2'>" + number + "</p><p class='text-center h4 mt-4'>" + roomTitle + "</p><p class='text-center h4'>Historyc suits with a cassic look</p><img class='mx-auto d-block rounded' src='./images/rooms/page_suitec8b7462-buona.jpeg' alt='Room'title='Room' width='90%'><div class='d-flex'><p class='text-blue marginLeft25 h3'><a href='./roomInformation.html'onclick='roomGlobal(" + rooms.childNodes[1].textContent + ")'>DETAILS >></a></p><p class='text-blue marginLeftRight h3'> BOOK >></p> </div></div>";
                    $("#roomtotal").html(div);
                //}
            });
            div +="</div>";


        }
    );
}


function getRoomByNumber(roomNumber){
    $.get(
        "/HotelOverLookJavaFX/src/main/resources/rooms.xml",
        function (xml, status) {
            var roomTitle = "";
            var beds = "";
            var guestAmount = "";
            var number = "";
            var price = "";
            var extras = "";
            var div =" <div class='row pt-5'>";
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
                    div += " <div class='col-xl-6'><p class='text-center text-blue font-SansSerifBldFLFCond h2'>" + number + "</p><p class='text-center h4 mt-4'>" + roomTitle + "</p><p class='text-center h4'>Historyc suits with a cassic look</p><img class='mx-auto d-block rounded' src='./images/rooms/page_suitec8b7462-buona.jpeg' alt='Room'title='Room' width='90%'><div class='d-flex'><p class='text-blue marginLeft25 h3'><a href='./roomInformation.html'onclick='roomGlobal(" + rooms.childNodes[1].textContent + ")'>DETAILS >></a></p><p class='text-blue marginLeftRight h3'> BOOK >></p> </div></div>";
                    $("#roomtotal").html(div);
                }
            });
            div +="</div>";


        }
    );
}
