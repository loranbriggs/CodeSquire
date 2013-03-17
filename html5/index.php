<?PHP include '../head.php'; ?>
  <!--
  <section>
    <br />
    <a href="rougeassassin/">Rouge Assassin</a>

  </section>
  -->
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>
      <div class="tabbable"> <!-- Only required for left/right tabs -->
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab1" data-toggle="tab">Rogue Assassin</a></li>
          <li><a href="#tab2" data-toggle="tab">Smoke and Fire</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="tab1">
            <a href="rougeassassin/"><h2>Rouge Assassin</h2>
            <img src="rougeassassin/images/startbg.png" /></a>
          </div>
          <div class="tab-pane" id="tab2">
            <a href="../smokeandfire/"><h2>Smoke and Fire</h2>
            <img src="../smokeandfire/images/croppedscreenshots.png" /></a>
          </div>
        </div>
      </div>
    </div>
    <div id='right-pannel' class='span2'>
      <?PHP include(ROOT.'/right_add_pannel.php'); ?>
    </div>
  </div>
<?PHP include(ROOT.'/foot.php'); ?>
