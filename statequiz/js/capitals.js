var stateCapitals =
  [
    ["Alabama", "Montgomery", "al"],
    ["Alaska", "Juneau", "ak"],
    ["Arizona", "Phoenix", "az"],
    ["Arkansas", "Little Rock", "ar"],
    ["California", "Sacramento", "ca"],
    ["Colorado", "Denver", "co"],
    ["Connecticut", "Hartford", "ct"],
    ["Delaware", "Dover", "de"],
    ["Florida", "Tallahassee", "fl"],
    ["Georgia", "Atlanta", "ga"],
    ["Hawaii", "Honolulu", "hi"],
    ["Idaho", "Boise", "id"],
    ["Illinois", "Springfield", "il"],
    ["Indiana", "Indianapolis", "in"],
    ["Iowa", "Des Moines", "ia"],
    ["Kansas", "Topeka", "ks"],
    ["Kentucky", "Frankfort", "ky"],
    ["Louisiana", "Baton Rouge", "la"],
    ["Maine", "Augusta", "me"],
    ["Maryland", "Annapolis", "md"],
    ["Massachusettes", "Boston", "ma"],
    ["Michigan", "Lansing", "mi"],
    ["Minnesota", "Saint Paul", "mn"],
    ["Mississippi", "Jackson", "ms"],
    ["Missouri", "Jefferson City", "mo"],
    ["Montana", "Helena", "mt"],
    ["Nebraska", "Lincoln", "ne"],
    ["Nevada", "Carson City", "nv"],
    ["New Hampshire", "Concord", "nh"],
    ["New Jersey", "Trenton", "nj"],
    ["New Mexico", "Santa Fe", "nm"],
    ["New York", "Albany", "ny"],
    ["North Carolina", "Raleigh", "nc"],
    ["North Dakota", "Bismark", "nd"],
    ["Ohio", "Columbus", "oh"],
    ["Oklahoma", "Oklahoma City", "ok"],
    ["Oregon", "Salem", "or"],
    ["Pennslyvania", "Harrisburg", "pa"],
    ["Rhode Island", "Providence", "ri"],
    ["South Carolina", "Columbia", "sc"],
    ["South Dakota", "Pierre", "sd"],
    ["Tennessee", "Nashville", "tn"],
    ["Texas", "Austin", "tx"],
    ["Utah", "Salt Lake City", "ut"],
    ["Vermont", "Montpelier", "vt"],
    ["Virginia", "Richmond", "va"],
    ["Washington", "Olympia", "wa"],
    ["West Virginia", "Charleston", "wv"],
    ["Wisconsin", "Madison", "wi"],
    ["Wyoming", "Cheyenne", "wy"]
  ];

var stateCapital;
var state;
var capital;
var abbr;
var questionType;
var prompt;
var answer;
var correctAnswer;
var hints = false;
var correct = 0;
var total   = 0;

function promptQuestion() {
  var random = Math.floor((Math.random() * 50));
  stateCapital = stateCapitals[random];
  state = stateCapital[0];
  capital = stateCapital[1];
  abbr    = stateCapital[2];
  var dropdown = document.getElementById("type");
  questionType = dropdown.selectedIndex;
  switch (questionType) {
    case 1:
      prompt = capital + " is the capital of what state?";
      document.getElementById("prompt").innerHTML = prompt;
      break;
    case 2:
      prompt = abbr.toUpperCase() + " is the abbrivation of what state?";
      document.getElementById("prompt").innerHTML = prompt;
      break;
    default:
      prompt = "What is the capital of " + state;
      document.getElementById("prompt").innerHTML = prompt;
  }
  document.getElementById("correct").innerHTML = correct;
  document.getElementById("total").innerHTML = total;
  setHint();
}

function enterButtonClicked() {
  var answer = document.getElementById("answer").value;
  answer = answer.trim();
  switch (questionType) {
    case 1:
      correctAnswer = state;
      break;
    case 2:
      correctAnswer = state;
      break;
    default:
      correctAnswer = capital;
  }
  if (correctAnswer.toLowerCase() == answer.toLowerCase()) {
    document.getElementById("solution").innerHTML = "correct!";
    correct++;
  } else {;
    document.getElementById("solution").innerHTML = "sorry, the correct answer is " + correctAnswer;
  }
  total++;
  clearHint();
  promptQuestion();
}


function hintButton() {
  var button = document.getElementById("hintButton");
  if (hints) {
    button.className = "btn btn-danger";
    button.value = "Hints Off";
    hints = false;
    clearHint()
  } else {
    button.className = "btn btn-success";
    button.value = "Hints On";
    hints = true;
    setHint();
  }
}

function setHint() {
  if (hints) {
    document.getElementById(abbr).className = "highlight";
  }
}

function clearHint() {
  var highlighted = document.getElementsByClassName("highlight");
  for (var i = 0; i < highlighted.length; i++) {
    highlighted[i].className = "";
  }
}

function test() {
  document.getElementById("solution").innerHTML = "test";
}
