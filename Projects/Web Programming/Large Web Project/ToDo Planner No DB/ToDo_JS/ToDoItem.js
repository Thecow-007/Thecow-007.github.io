/* DANIEL */
let ToDoList = [];
let ToDoItems = [];
let tagList = [];

// toggles the class 'active' to the object with given ID
function toggleActive(elementID) {
    var element = document.getElementById(elementID);
    element.classList.toggle('active');
    printList();
}
function toggleCrossed(elementID) {
    var element = document.getElementById(elementID);
    element.classList.toggle('crossed');
    printList();
}

function addToDo() {
    let defaultToDo = {
        isChecked: false,
        title: "Click to add title...",
        tags: ["new tag..."]
    }
    ToDoList.push(defaultToDo);
    printList();
}

function appendToDo(item, index) {
    var listItem = document.createElement('div');
    listItem.className = 'ToDo-item';
    listItem.id = "item" + index;
    listItem.innerHTML = `
        <div class="checkbox">
            <input type="checkbox" ${item.isChecked ? "checked" : ""} id="item-checkbox${index}">
        </div>
      <div class="ToDo-item-title">
        <h3 id="item-title${index}">${item.title}</h3>
      </div>
      <div class="ToDo-item-tags" id="item-tags${index}">
        <div class="tag-title">
          <h4>Tags:</h4>
        </div>
        ${generateTag(index)}
      </div>
      <div class="remove-container">
             <button class="remove-button" onclick="removeToDo('${index}')">-</button>
        </div>`;
    document.getElementById('ToDo-Items').appendChild(listItem);
    return listItem;
}


function incrementTagColorCounter(amount) {
    let tagColorCounter = 0;
    for (var i = 0; i < amount; i++) {
        // Check if counter has reached 11, if so reset it to 0
        if (tagColorCounter > 10) {
            tagColorCounter = 0;
        }
        tagColorCounter++;
    }
    return tagColorCounter;
}

function generateTag(index) {
    var tagString = ``;
    for (var i = 0; i < ToDoList[index].tags.length; i++) {
        var colorIndex = incrementTagColorCounter(tagList.indexOf(ToDoList[index].tags[i]));
        tagString += `<div class="tag${colorIndex} tag" id="item${index}-tag${i}"><p>${ToDoList[index].tags[i]}</p></div>`;
    }
    return tagString;
}

// Getters and Setters
function setChecked(index, checked) {
    ToDoList[index].ischecked = checked;
}

function setTitle(index, newTitle) {
    ToDoList[index].title = newTitle;
}

function setDate(index, newDate) {
    ToDoList[index].date = newDate;
}

function addTag(index, newTag) {
    var isIndexTag = ToDoList[index].tags.indexOf(newTag);
    var isTag = tagList.indexOf(newTag);
    if (isTag == -1 && isIndexTag == -1) {
        tagList.push(newTag);
        ToDoList[index].tags.push(newTag);
        return true;
    } else if (isTag == -1) {
        tagList.push(newTag);
        return true;
    } else if (isIndexTag == -1) {
        ToDoList[index].tags.push(newTag);
        return true;
    }
    return false;
}

function removeTag(index, oldTag) {
    // Check if the tag is not used by any todo item
    var listIndex = tagList.indexOf(oldTag);
    if (!ToDoList.some(ToDoList => ToDoList.tags.includes(oldTag))) { //checks for other items with same tag.
        tagList.splice(listIndex, 1); //remove the unused tag from the array
    }
    var tagIndex = ToDoList[index].tags.indexOf(oldTag); // Find the index of oldTag in the tags array
    if (tagIndex !== -1) { // If oldTag is found in the array
        ToDoList[index].tags.splice(tagIndex, 1); // Remove oldTag from the tags array
    }
}

function removeToDo(index) {
    for (var tag of ToDoList[index].tags) {
        removeTag(index, tag);
    }
    ToDoList.splice(index, 1);
    printList();
}

function printList() {
    if(ToDoItems == null || document.getElementById('ToDo-Items') == null){
        return false;
    }
    // copy ToDoList into ToDoItems
    ToDoItems = JSON.parse(JSON.stringify(ToDoList));
    //ToDo: apply filters and search functions
    sortToDoList(); // applies filters, or "sorts"
    searchToDoList(); //apply the search filter

    document.getElementById('ToDo-Items').innerHTML = "";
    tagList.splice(0, tagList.length);
    for (var i = 0; i < ToDoList.length; i++) {
        sortTagArray(i);
        var ToDoItem = appendToDo(ToDoList[i], i);
        addToDoEvents(ToDoItem);
    }
    //copy ToDoItems to ToDoList
    ToDoList = JSON.parse(JSON.stringify(ToDoItems));
}

function addToDoEvents(ToDoItem) {
    var itemId = ToDoItem.id;
    var itemIndex = itemId.substring(4);
    var itemTitle = document.getElementById("item-title" + itemIndex);
    var itemTags = tagsToArray(itemIndex);
    var itemCheckBox = document.getElementById("item-checkbox" + itemIndex);

    // Add the event listeners
    // Title event listener
    itemTitle.addEventListener("click", function () {
        gatherTitleInput(itemIndex);
    });

    // Tags Event listener
    itemTags.forEach(function (element) {
        element.addEventListener("click", function () {
            gatherTagInput(itemIndex, element.id);
        });
    });

    // Checkbox event listener
    itemCheckBox.addEventListener("click", function () {
        ToDoList[itemIndex].isChecked = !ToDoList[itemIndex].isChecked;
        toggleCrossed("item-title" + itemIndex);
        printList();
    });
}

// Functions to replace text with textbox and vice versa. TitleItem will be the div container,
//Containing the h3 tag of the title. This is what will be swapped.
function gatherTitleInput(index) {
    var titleText = ToDoList[index].title;

    var inputElement = document.createElement('input');
    inputElement.type = "text";
    inputElement.value = titleText;
    inputElement.id = "item-title-bar" + index;
    inputElement.className = "item-title-bar";

    var oldh3 = document.getElementById("item-title" + index);
    let oldh3Value = oldh3.textContent;
    var titleContainer = oldh3.parentNode;

    titleContainer.replaceChild(inputElement, oldh3);

    // Focus on the input field
    inputElement.focus();
    inputElement.select();

    inputElement.addEventListener("keypress", function (event) {
        if ((inputElement.value.trim() == "") && (event.key === "Enter")) {
            // If the input field is empty, revert back to <h3>
            ToDoList[index].title = oldh3Value;
            printList();
        } else if (event.key === "Enter") {
            ToDoList[index].title = inputElement.value;
            printList();
        }
    });

    inputElement.addEventListener("blur", function () {
        if (inputElement.value.trim() == "") {
            // If the input field is empty, revert back to <h3>
            ToDoList[index].title = oldh3Value;
            printList();
        } else {
            ToDoList[index].title = inputElement.value;
            printList();
        }
    });
}

//Function to collect tag input
function gatherTagInput(index, tagID) {
    numbers = tagID.match(/\d+/g);
    tagIndex = numbers[1];

    var tag = document.getElementById(tagID);
    var tagValue = document.querySelector("#" + tagID + " p").textContent;
    var tagContainer = tag.parentElement;

    var inputElement = document.createElement('input');
    inputElement.type = "text";
    inputElement.value = tagValue;
    inputElement.id = "item-tag-bar" + index;
    inputElement.className = "item-tag-bar";

    tagContainer.replaceChild(inputElement, tag);

    // Focus on the input field
    inputElement.focus();
    inputElement.select();

    inputElement.addEventListener("keypress", function (event) {
        if ((tagValue == "new tag...") && (event.key === "Enter")) {
            removeTag(index, tagValue);
            addTag(index, inputElement.value);
            printList();
        }
        else if ((inputElement.value.trim() == "") && (event.key === "Enter")) {
            // If the input field is empty, remove the tag
            removeTag(index, tagValue);
            printList();
        } else if (event.key === "Enter") {
            removeTag(index, tagValue);
            addTag(index, inputElement.value);
            printList();
        }
    });

    inputElement.addEventListener("blur", function () {
        if (inputElement.value.trim() == "") {
            // If the input field is empty, revert back to regular tag value
            printList();
        } else if (!(tagValue == "new tag...")) {
            removeTag(index, tagValue);
            addTag(index, inputElement.value);
            printList();
        } else if (tagValue == "new tag...") {
            removeTag(index, tagValue);
            addTag(index, inputElement.value);
            printList();
        }
    });
}

function sortTagArray(index) {
    var tagArray = ToDoList[index].tags;
    tagArray = tagArray.filter(function (tag) {
        if (tag != "new tag...") {
            addTag(index, tag);
        }
    }).sort();
    addTag(index, "new tag...");
}

function tagsToArray(index) {
    let tagsArray = ToDoList[index].tags;
    let outputArray = [];
    for (var i = 0; i < tagsArray.length; i++) {
        outputArray.push(document.getElementById("item" + index + "-tag" + i));
    }
    return outputArray;
}

function sortToDoList() {
    //if sort alphebetical
    let isAlpha = document.getElementById('alpha-button').checked;
    let isReverse = document.getElementById('reverse-button').checked;
    let isByTag = document.getElementById('tag-button').checked;


    if (isAlpha) {
        ToDoList.sort((a, b) => {
            // Convert titles to lowercase for case-insensitive sorting
            var titleA = a.title.toLowerCase();
            var titleB = b.title.toLowerCase();

            if (titleA < titleB) return -1;
            if (titleA > titleB) return 1;
            return 0;
        });
    } else if (isReverse) {
        ToDoList.sort((a, b) => {
            // Convert titles to lowercase for case-insensitive sorting
            var titleA = a.title.toLowerCase();
            var titleB = b.title.toLowerCase();

            if (titleA < titleB) return 1;
            if (titleA > titleB) return -1;
            return 0;
        });
    }

    if (isByTag) {
        ToDoList.sort((a, b) => {
            // Convert titles to lowercase for case-insensitive sorting
            var tagA = JSON.stringify(a.tags);
            var tagB = JSON.stringify(b.tags);
            if (tagA < tagB) return -1;
            if (tagA > tagB) return 1;
            return 0;
        });
    }
}

function addFilterWindowListener() {
    let filterButtons = document.getElementsByClassName('filter');
    Array.from(filterButtons).forEach(function (button) {
        button.addEventListener("change", printList);
    });
}

function addSearchBarListener() {
    if(document.getElementById('search-bar') == null){
        return false;
    }
    let searchBar = document.getElementById('search-bar');
    searchBar.addEventListener("keypress", function (event) {
        if (event.key === "Enter") {
            printList();
        }
    })
}


function addSaveListener() {
    if(document.getElementById('save-button') == null){
        return false;
    }
    let saveButton = document.getElementById('save-button');
    saveButton.addEventListener("click", function () {
        // Create a form element
        var form = document.createElement("form");
        form.method = "POST";
        form.action = ""; // This will post the form data to the current URL

        // Create a hidden input field to hold the ToDoList data
        var input = document.createElement("input");
        input.type = "hidden";
        input.name = "ToDoList";
        input.value = JSON.stringify(ToDoList);
        // Append the input field to the form
        form.appendChild(input);

        // Append the form to the document body
        document.body.appendChild(form);

        // Submit the form
        form.submit();
    });
}

function addDefaultisteners() {
    addFilterWindowListener();
    addSearchBarListener();
    addSaveListener();
}

function searchToDoList() {
    if(document.getElementById('search-bar') == null){
        return false;
    }
    var output = [];
    var searchElement = document.getElementById('search-bar');
    var searchVal = searchElement.value;
    const regex = new RegExp(".*" + searchVal + ".*");
    for (item of ToDoList) {
        if (regex.test(item.title)) {
            output.push(item);
        } else if (regex.test(JSON.stringify(item.tags))) {
            output.push(item);
        }
    }
    ToDoList = output;
}

addDefaultisteners();//adds the listeners which arent removed every printlist.

printList();