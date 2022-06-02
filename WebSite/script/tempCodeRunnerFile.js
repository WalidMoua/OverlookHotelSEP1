const startD = new Date();
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