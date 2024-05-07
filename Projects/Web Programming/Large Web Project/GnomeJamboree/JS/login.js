// Function used to validate whether to let a login through to PHP. Returns true if we should let the user post to PHP.
function validateLogin(){
    const email = document.getElementById("email");
    const pass = document.getElementById("pass");
    const emailMessage = document.getElementById("email-message");
    const passMessage = document.getElementById("pass-message");

    let emailRegEx = /^[^@]+@[^@]+\.[^@]+$/; //tests if an input is like an email, not foolproof.

    let goodInput = true; //if this gets set to false, the input will not be sent.

    if(!emailRegEx.test(email.value)){
        emailMessage.innerText = "Email must be in the form: [xyz]@[xyz].[xyz]";
        email.classList.add("error");
        goodInput = false;
    }
    if(email.value == ""){
        emailMessage.innerText = "Email cannot be empty.";
        email.classList.add("error");
        goodInput = false;
    }
    if(pass.value == ""){
        passMessage.innerText = "Password cannot be empty.";
        pass.classList.add("error");
        goodInput = false;
    }
    
    //ToDo: Additional Checks for password length and content. 6 chars + 1 upper + 1 lower?

    return goodInput; //return true if all tests pass.
}