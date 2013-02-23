<?PHP include '../head.php'; ?>
  <!--
  <section>
    <br />
    <a href="http://apps.microsoft.com/windows/app/pythagoreantheorem/2d55f7da-64e0-42cb-aaa8-b4e82523a722">PythagoreanTheorem</a> |
    <a href="http://apps.microsoft.com/windows/app/rogue-assassin/a116ea25-6e9a-473a-a0fe-510d294e9ae0">Rogue Assassin</a>

  </section>
  -->
  <div class="tabbable"> <!-- Only required for left/right tabs -->
    <ul class="nav nav-tabs">
      <li class="active"><a href="#tab1" data-toggle="tab">Pythagorean Theorem</a></li>
      <li><a href="#tab2" data-toggle="tab">Rogue Assassin</a></li>
    </ul>
    <div class="tab-content">
      <div class="tab-pane active" id="tab1">
        <h2>Pythagorean Theorem</h2>
        <iframe 
          seamless
          src="http://apps.microsoft.com/windows/app/pythagoreantheorem/2d55f7da-64e0-42cb-aaa8-b4e82523a722"
          class="well"
          >
        </iframe>
      </div>
      <div class="tab-pane" id="tab2">
        <h2>Rogue Assassin</h2>
        <iframe 
          seamless
          src="http://apps.microsoft.com/windows/app/rogue-assassin/a116ea25-6e9a-473a-a0fe-510d294e9ae0"
          class="well"
          >
        </iframe>
      </div>
    </div>
  </div>
<?PHP include(ROOT.'/foot.php'); ?>
