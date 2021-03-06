<?PHP include '../head.php'; ?>
  <!--
  <section>
    <br />
    <a href="playfairscipher/">Playfair's Cipher</a> |
    <a href="polynomials/">Polynomials</a>
  </section>
  -->
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>
      <div class="tabbable"> <!-- Only required for left/right tabs -->
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab1" data-toggle="tab">Playfair's Cipher</a></li>
          <li><a href="#tab2" data-toggle="tab">Polynomials</a></li>
          <li><a href="#tab3" data-toggle="tab">Hex Puzzle</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="tab1">
            <h2>Playfair's Cipher</h2>
            <applet
              class = "well"
              codebase = "playfairscipher/"
              code = "PlayfairCipher.class"
              width = 480
              height = 320
              align = "center"
              alt = "error"
            >
            </applet>
            <p class = "well">
              Download the source code 
              <a href="playfairscipher/PlayfairCipher.java">Here</a>
            </p>
          </div>
          <div class="tab-pane" id="tab2">
            <h2>Polynomials</h2>
            <applet
              class = "well"
              codebase = "polynomials/"
              code = "Polynomials.class"
              width = 500
              height = 350
              align = "center"
              alt = "error"
            >
            </applet>
            <p class = "well">
              Download the source code 
              <a href="polynomials/Polynomials.zip">Here</a>
            </p>
          </div>
          <div class="tab-pane" id="tab3">
            <h2>Hex Puzzle</h2>
            <applet
              class = "well"
              codebase = "hexpuzzle/"
              code = "HexPuzzle.class"
              width = 350
              height = 650
              align = "center"
              alt = "error"
            >
            </applet>
            <p class = "well">
              Download the source code 
              <a href="hexpuzzle/HexPuzzle.zip">Here</a>
            </p>
          </div>
        </div>
      </div>
    </div>
    <div id='right-pannel' class='span2'>
      <?PHP include(ROOT.'/right_add_pannel.php'); ?>
    </div>
  </div>
<?PHP include(ROOT.'/foot.php'); ?>
