<?PHP include '../head-half1.php'; ?>
  <title>Smoke and Fire</title>
  <meta property="og:title" content="Smoke and Fire" />
  <meta property="og:type" content="website" />
  <meta property="of:image" content="http://codesquire.com/smokeandfire/images/logo.png" />
  <meta property="og:url" content="http://codesquire.com/smokeandfire/" />
  <meta property="og:description" content="Smoke and Fire the simple and fun drinking game. Now no deck required with this browser game! " />
  <meta property="og:site_name" content="CodeSquire" />
<?PHP include '../head-half2.php'; ?>
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>

      <link href="css/default.css" rel="stylesheet" />
      <script src="js/smokeandfire.js">
      </script>
      <h1>Smoke and Fire</h1>
      <h2 id="prompt-main">*</h2>
      <div id="prompt-image">
        <img id="prompt1" class="promptButton" onclick="clickedButton(1)" alt="" src="" /></li>
        <img id="prompt2" class="promptButton" onclick="clickedButton(2)" alt="" src="" /></li>
        <img id="prompt3"  class="promptButton" onclick="clickedButton(3)" alt="" src="" /></li>
        <img id="prompt4" class="promptButton" onclick="clickedButton(4)" alt="" src="" /></li>
      </div>
      <label id="outcome"></label>
      <div id="cards">
        <img id="card1" class="hide" alt="" src="" /></li>
        <img id="card2" class="hide" alt="" src="" /></li>
        <img id="card3" class="hide" alt="" src="" /></li>
        <img id="card4" class="hide" alt="" src="" /></li>
        <img id="card5" class="hide" alt="" src="" /></li>
        <img id="card6" class="hide" alt="" src="" /></li>
      </div>
      <label id="scoreDisplay">Drinks to take: <span id="score">0</span></label>
      <br />
      <button id="reset" type="button" class="btn btn-inverse hide" onclick="resetGame()">Reset</button>

      <div id="warning" style="" 
        <p>
          "drinks" refer to a substance that <strong>YOU</strong> are legally 
          able to consume. This game is not inteded to be played
          by underage people. 
        </p>
      </div>
    </div>
    <div id='right-pannel' class='span2'>
      <?PHP include(ROOT.'/right_add_pannel.php'); ?>
    </div>
  </div>
  <script>
    window.onload = prompt();
  </script>
<?PHP include(ROOT.'/foot.php'); ?>
