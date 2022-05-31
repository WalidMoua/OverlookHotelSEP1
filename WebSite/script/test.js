//Check if 2 dates are overlapping (date must be an object with check-in as start date and check-out as ending date)

const date1 = new Date("1997-11-20");

console.log(date1);

/* function getXmlFile() {
  var roomsXml = 1;
  let bookingXml;

  /*  bookingXml = $.get(
    "/HotelOverLookJavaFX/src/main/resources/bookings.xml",
    function (xml, status) {
      bookingXml = $(xml);
      console.log(bookingXml.find("name"));
    }
  ); 

  roomsXml = $.get(
    "/HotelOverLookJavaFX/src/main/resources/student.xml",
    function (xml, status) {
      roomsXml = $(xml);
      console.log(roomsXml.find("name").text());
    }
  );

  console.log(roomsXml);
} */

/* function filterList(filter) {
  var filtered = roomList.filter((room) => {
    return room != filter;
  });
  return filtered;
}

function rooms() {
  roomList.map((rooms) => {
    rooms.single.room.available;
  });
}

const d = new Date();
const tomorrow = new Date();
tomorrow.setDate(tomorrow.getDate() + 1); */

//if (endD >= startdate && startD <= enddate) // comparing dates

//if ( !(endD < startdate || startD > enddate)) // not one after the other comparing dates

///CHECK OVERLAPPING DATES TES////
/* const startD = new Date();    
const endD = new Date();
endD.setDate(endD.getDate() + 10);

const startDate = new Date();
startDate.setDate(startD.getDate() + 11);
const endDate = new Date();
endDate.setDate(endDate.getDate() + 11);

date1 = {
  checkIn: startD,
  checkOut: endD,
};

date2 = {
  checkIn: startDate,
  checkOut: endDate,
};

function isOverlapping(date1, date2) {
  date1Start = date1.checkIn;
  date1End = date1.checkOut;

  date2Start = date2.checkIn;
  date2End = date2.checkOut;

  if (!(date1End >= date2Start && date1Start <= date2End)) {
    console.log("not overlapping");
    return false;
  } else console.log("Overlapping");
  return true;
}
console.log(isOverlapping(date1, date2));

*/
