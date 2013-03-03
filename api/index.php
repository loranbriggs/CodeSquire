<?PHP include '../head.php'; ?>
  <!--
  <section>
    <br />
    <a href="http://twittermap.codesquire.com/">Twitter Map</a>
  </section>
  -->
  <div class='row-fluid'>
    <div id='main-pannel' class='span10'>
      <div class="text-center">
        <h2><a href="http://twittermap.codesquire.com/">Twitter Maps</a></h2>
          <iframe 
            seamless
            src="http://twittermap.codesquire.com/"
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
