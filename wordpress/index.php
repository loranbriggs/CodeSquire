<?PHP include '../head.php'; ?>
  <!--
  <section>
    <br />
    <a href="http://www.aiccu.edu/">Aiccu.edu</a> |
    <a href="http://bigorangebookfestival.com/">BigOrangeBookFestival.com</a>
  </section>
  -->
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>
      <div class="tabbable"> <!-- Only required for left/right tabs -->
        <ul class="nav nav-tabs">
          <li class="active"><a href="#tab1" data-toggle="tab">AICCU</a></li>
          <li><a href="#tab2" data-toggle="tab">Big Orange Book Fesitival</a></li>
        </ul>
        <div class="tab-content">
          <div class="tab-pane active" id="tab1">
            <h2><a href="http://www.aiccu.edu/">AICCU.edu</a></h2>
            <h3>Association of Independent California Colleges and Universities</h3>
            <iframe 
              seamless
              src="http://www.aiccu.edu/"
              class="well"
              >
            </iframe>
          </div>
          <div class="tab-pane" id="tab2">
            <h2><a href="http://bigorangebookfestival.com/">Big Orange Book Fesitival</a></h2>
            <iframe 
              seamless
              src="http://bigorangebookfestival.com/"
              class="well"
              >
            </iframe>
          </div>
        </div>
      </div>
    </div>
    <div id='right-pannel' class='span2'>
      <?PHP include(ROOT.'/right_add_pannel.php'); ?>
    </div>
  </div>
<?PHP include(ROOT.'/foot.php'); ?>
