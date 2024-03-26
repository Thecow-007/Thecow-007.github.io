//validate email: must be [xyz]@[xyz].[xyz]

//validate login name: not empty, no more than 20chars, when posted will be all lower case.

//password: must be 6 chars long, 1 uppercase, 1 lowercase. Both password fields must have the same value.

//if user selected newsletter, alert them about possible spam by setting an event on this field.

//terms and conditions: must be checked.

function validate(){ //this function runs all of the sub-functions which validate each section.
    resetMessages();

    //keep these lines if you want all errors to display at once, not just the first one.
    validateEmail();
    validateUserName();
    validatePassword();
    validatePasswordMatch();
    validateTerms();

    if(validateEmail() && validateUserName() && validatePassword() && validatePasswordMatch() && validateTerms()){
        const form = document.getElementById("registrationForm");
        form.submit();
    }
}

function validateEmail(){
    const email = document.getElementById("email").value;

    if(/^[^@]+@[^@]+\.[^@]+$/.test(email)){
        return true;
    }
    else{
        const emailMessage = document.getElementById("emailMessage");
        emailMessage.innerText = "Email must be in the form: [xyz]@[xyz].[xyz]"
        return false;
    }
}

function validateUserName(){
    const login = document.getElementById("login").value;

    if(login.length > 20 || login.length < 1){
        const loginMessage = document.getElementById("loginMessage");
        loginMessage.innerText = "Username must be between 1 and 20 characters."
        return false;
    }
    else{
        return true;
    }
}

function validatePassword(){
    const password = document.getElementById("pass").value;
    
    //tests length > 5, if contains lowercase, if contains uppercase.
    if(password.length > 5 && /[a-z]/.test(password) && /[A-Z]/.test(password)){
        return true;
    }
    else{
        const passwordMessage = document.getElementById("passMessage");
        passwordMessage.innerText = "Password must contain at least 6 characters, 1 uppercase, and 1 lowercase."
        return false;
    }
}

function validatePasswordMatch(){
    const password = document.getElementById("pass").value;
    const password2 = document.getElementById("pass2").value;

    if(password === password2){
        return true;
    }
    else{
        const passwordMessage = document.getElementById("pass2Message");
        passwordMessage.innerText = "Passwords must match";
        return false;
    }
}

function validateNewsLetter(){
    const newsLetter = document.getElementById("newsletter");

    if(newsLetter.checked){
        alert("Warning: this may result in spam emails");
        return true;
    }
    else{
        return false;
    }
}

function validateTerms(){
    const terms = document.getElementById("terms");

    if(terms.checked){
        return true;
    }
    else{
        const termsMessage = document.getElementById("termsMessage");
        termsMessage.innerText = "Please accept the Terms and Conditions"
    }
}

function resetMessages(){
    const messages = document.getElementsByClassName("message");
    for(var message of messages){
        message.innerText = "";
    }
}