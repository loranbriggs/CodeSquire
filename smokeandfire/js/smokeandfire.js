var question = 0;
function Card() {
  var randSuit = Math.floor((Math.random() * 4) + 1);
  switch(randSuit) {
    case 1:
      this.suit = "s";
      break;
    case 2:
      this.suit = "h";
      break;
    case 3:
      this.suit = "c";
      break;
    case 4:
      this.suit = "d";
      break;
  }
  this.rank = Math.floor((Math.random() * 12) + 1);
  if (this.rank < 10)
    this.getString = "cards/" + this.suit + this.rank + ".png";
  else if (this.rank = 10)
    this.getString = "cards/" + this.suit + "j.png";
  else if (this.rank = 11)
    this.getString = "cards/" + this.suit + "q.png";
  else if (this.rank = 12)
    this.getString = "cards/" + this.suit + "k.png";

}

var cards = [];
var score = 0;

function prompt() {
  switch (question % 4) {
    case 0:
      document.getElementById("prompt-main").innerHTML = "Smoke or Fire?";
      document.getElementById("prompt1").className = "hide";
      document.getElementById("prompt2").src = "images/smoke.png";
      document.getElementById("prompt2").className = "";
      document.getElementById("prompt3").src = "images/fire.png";
      document.getElementById("prompt3").className = "";
      document.getElementById("prompt4").className = "hide";
      break;
    case 1:
      document.getElementById("prompt-main").innerHTML = "Higher or Lower?";
      document.getElementById("prompt1").className = "hide";
      document.getElementById("prompt2").src = "images/add.png";
      document.getElementById("prompt3").src = "images/minus.png";
      document.getElementById("prompt4").className = "hide";
      break;
    case 2:
      document.getElementById("prompt-main").innerHTML = "Inbetween or Outside?";
      document.getElementById("prompt1").className = "hide";
      document.getElementById("prompt2").src = "images/inside.png";
      document.getElementById("prompt3").src = "images/outside.png";
      document.getElementById("prompt4").className = "hide";
      break;
    case 3:
      document.getElementById("prompt-main").innerHTML = "Pick a suit";
      document.getElementById("prompt1").src = "cards/s1.png";
      document.getElementById("prompt2").src = "cards/h1.png";
      document.getElementById("prompt3").src = "cards/c1.png";
      document.getElementById("prompt4").src = "cards/d1.png";
      document.getElementById("prompt1").className = "";
      document.getElementById("prompt2").className = "";
      document.getElementById("prompt3").className = "";
      document.getElementById("prompt4").className = "";
      break;
    default:
      document.getElementById("prompt-main").innerHTML = "default?";
  }

}

function clickedButton(p) {
  switch (question % 4) {
    case 0:
      cards.push(new Card());
      switch (p) {
        case 2:
          if (cards[0].suit == "h" || cards[0].suit == "d") {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[0].rank + " drinks";
            score += cards[0].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
        case 3:
          if (cards[0].suit == "s" || cards[0].suit == "c") {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[0].rank + " drinks";
            score += cards[0].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
      }
      document.getElementById("score").innerHTML = score;
      document.getElementById("outcome").className = "";
      document.getElementById("card3").src = cards[0].getString;
      document.getElementById("card3").className = "";
      document.getElementById("card1").className = "hide";
      document.getElementById("card2").className = "hide";
      document.getElementById("card4").className = "hide";
      document.getElementById("card5").className = "hide";
      document.getElementById("card6").className = "hide";
      break;
    case 1:
      cards.push(new Card());
      switch (p) {
        case 2:
          if (cards[1].rank < cards[0].rank) {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[1].rank + " drinks";
            score += cards[1].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
        case 3:
          if (cards[1].rank > cards[0].rank) {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[1].rank + " drinks";
            score += cards[1].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
      }
      document.getElementById("score").innerHTML = score;
      if (cards[0].rank > cards[1].rank) {
        var temp = cards[0];
        cards[0] = cards[1];
        cards[1] = temp;
      } 
      document.getElementById("card1").className = "hide";
      document.getElementById("card2").src = cards[0].getString;
      document.getElementById("card2").className = "";
      document.getElementById("card3").className = "hide";
      document.getElementById("card4").src = cards[1].getString;
      document.getElementById("card4").className = "";
      document.getElementById("card5").className = "hide";
      break;
    case 2:
      cards.push(new Card());
      switch (p) {
        case 2:
          if (cards[2].rank > cards[1].rank || cards[2].rank < cards[0].rank) {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[2].rank + " drinks";
            score += cards[2].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
        case 3:
          if (cards[2].rank < cards[1].rank && cards[2].rank > cards[0].rank) {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[2].rank + " drinks";
            score += cards[2].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
      }
      document.getElementById("score").innerHTML = score;
      if ( (cards[2].rank < cards[0].rank) && (cards[2].rank < cards[1].rank) ) {
        document.getElementById("card1").src = cards[2].getString;
        document.getElementById("card1").className = "";
      } else if ((cards[2].rank > cards[0].rank) && (cards[2].rank > cards[1].rank)) {
        document.getElementById("card5").src = cards[2].getString;
        document.getElementById("card5").className = "";
      } else {
        document.getElementById("card3").src = cards[2].getString;
        document.getElementById("card3").className = "";
      }
      break;
    case 3:
      cards.push(new Card());
      switch (p) {
        case 1:
          if (cards[3].suit != "s") {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[3].rank + " drinks";
            score += cards[3].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
        case 2:
          if (cards[3].suit != "h") {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[3].rank + " drinks";
            score += cards[3].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
        case 3:
          if (cards[3].suit != "c") {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[3].rank + " drinks";
            score += cards[3].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
        case 4:
          if (cards[3].suit != "d") {
            document.getElementById("outcome").innerHTML = "Wrong take "
              + cards[3].rank + " drinks";
            score += cards[3].rank;
          } else {
            document.getElementById("outcome").innerHTML = "Correct! You're safe!";
          }
          break;
      }
      document.getElementById("score").innerHTML = score;
      document.getElementById("card6").src = cards[3].getString;
      document.getElementById("card6").className = "";

      document.getElementById("prompt1").className = "hide";
      document.getElementById("prompt2").className = "hide";
      document.getElementById("prompt3").className = "hide";
      document.getElementById("prompt4").className = "hide";

      document.getElementById("reset").className = "btn btn-inverse";
  }
  question++;
  if (question < 4)
    prompt();
}

function resetGame() {
  cards = [];
  document.getElementById("card1").className = "hide";
  document.getElementById("card2").className = "hide";
  document.getElementById("card3").className = "hide";
  document.getElementById("card4").className = "hide";
  document.getElementById("card5").className = "hide";
  document.getElementById("card6").className = "hide";
  score = 0;
  document.getElementById("score").innerHTML = score;
  question = 0;
  document.getElementById("reset").className = "hide";
  document.getElementById("outcome").className = "hide";
  prompt();
}
