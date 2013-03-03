<?PHP include '../head.php'; ?>
  <!--
  <section>
    <br />
    <a href="https://rockreation.herokuapp.com/">Rockreation Reservation System</a>
  </section>
  -->
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>
      <div class="text-center">
        <h2><a href="https://rockreation.herokuapp.com/">Rockreation Reservation System</a></h2>
          <iframe 
            seamless
            src="https://rockreation.herokuapp.com/"
            class="well"
            >
          </iframe>
      </div>
    </div>
    <div id='right-pannel' class='span2'>
      <?PHP include(ROOT.'/right_add_pannel.php'); ?>
    </div>
  </div>
<?PHP include(ROOT.'/foot.php'); ?>
