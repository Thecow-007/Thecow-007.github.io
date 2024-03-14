function updateClock(){
    const now = new Date();
    let weekday = now.toLocaleString('default', { weekday: 'long' });
    let month = now.toLocaleString('default', { month: 'long' });
    let dayOfMonth = now.getDate();
    //add 'st' 'rd' and 'th'.
    dayOfMonth = updateDayOfMonth(dayOfMonth);
    let year = now.getFullYear();
    let hours = now.getHours();
    let minutes = now.getMinutes();
    let seconds = now.getSeconds();

    let HMS = updateHours(hours, minutes, seconds);

    const clock = document.getElementById("clock");

    let timeOutput = weekday + " " + month + " " + dayOfMonth + " " + year + ", " + HMS;

    clock.innerText = timeOutput;

    setTimeout(updateClock, 100)
}

function updateDayOfMonth(dayOfMonth){
    let lastDigit = Math.floor(parseInt(dayOfMonth) % 10);
    if(lastDigit === 1){
        return dayOfMonth + "st";
    }
    else if(lastDigit === 2){
        return dayOfMonth + "nd";
    }
    else if(lastDigit === 3){
        return dayOfMonth + "rd";
    }
    else{
        return dayOfMonth + "th";
    }
}

function updateHours(hours, minutes, seconds){
    if(hours > 12){
        return (hours - 12) + ":" + minutes + ":" + seconds + " PM";
    }
    return hours + ":" + minutes + ":" + seconds + " AM";

}

//initial call
updateClock();
