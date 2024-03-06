function checkGuess(){
    var userGuess = parseInt(document.getElementById("guess").value);
    console.log("user's guess: " + userGuess);
    console.log("Secret number: " + secretNumber);
    
    if(userGuess === secretNumber){
        alert("You guessed it!");
        var answer_paragraph = document.getElementById("number-answer");
        answer_paragraph.textContent = ("The number was: " + secretNumber + "!");
    }
    else if(userGuess > secretNumber){
        alert("Too High!");
    }
    else{
        alert("Too Low!");
    }
}

function newNumber(){
    secretNumber = Math.round(Math.random() * 10);

    var answer_paragraph = document.getElementById("number-answer");
    answer_paragraph.textContent = ("Your guess is:");
}

// Generate the first random number
newNumber();

console.log(secretNumber);



