<?PHP include '../head.php'; ?>
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>
      
      <h1>Windows Store Apps</h1>
      <ul class="linkList">
        <li><a href="http://apps.microsoft.com/windows/app/rogue-assassin/a116ea25-6e9a-473a-a0fe-510d294e9ae0">
          Rogue Assassin</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/twitter-maps/5541b087-55ef-453c-8b99-1eccde53f60a">
          Twitter Maps</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/state-quiz/fc17e4bf-7bcd-458f-9d42-23e6f4167c9d">
          State Capitals Quiz</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/pythagoreantheorem/2d55f7da-64e0-42cb-aaa8-b4e82523a722">
          Pythagorean Theorem</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/yoda-speak/ff0fae6e-cee0-424c-940d-b8ffd350626d">
          Yoda Speak</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/tip-calculator-simple/d5b9c3a9-72a2-42a4-8d4f-3af5154953b4">
          Tip Calculator</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/loan-calculator-simple/f66db96c-6f1c-4d1a-9534-ed1350b5f4b6">
          Loan Calculator</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/coinflipper/412e2ba8-1b7a-4ef2-a911-97162c267b25">
          Coin Flipper</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/an-apple-a-day/e461d431-623d-4ab2-8d51-1e54748518d7">
          An Apple A Day</a></li>
        <li><a href="http://apps.microsoft.com/windows/app/rock-paperweight-scissors/00c01fb7-44f7-4f92-977c-bd644e65100b">
          Rock Paper Scissors</a></li>
        <li><a href="#">
          More to come...</a></li>
      </ul> 
      <script>
        $(".linkList a:even").addClass("btn btn-success");
        $(".linkList a:odd").addClass("btn btn-info");
      </script>
    </div>
    <div id='right-pannel' class='span2'>
      <?PHP include(ROOT.'/right_add_pannel.php'); ?>
    </div>
  </div>
<?PHP include(ROOT.'/foot.php'); ?>
