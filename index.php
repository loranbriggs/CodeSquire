<?PHP include 'head.php'; ?>

  <div id="twitter-feed" class="well">
    <div id="tweet"></div>
  </div><!-- end twitter-feed -->

  <div class="instagram" class="text-center"></div>

  <!-- for twitter feed -->
  <script 
    src="http://twitterjs.googlecode.com/svn/trunk/src/twitter.min.js" 
    type="text/javascript">
  </script>
  <script type="text/javascript" charset="utf-8">
    getTwitters('tweet', { 
      id: 'codesquire', 
      count: 1, 
      enableLinks: true, 
      ignoreReplies: true, 
      clearContents: true,
      template: '"%text%" <a target="_blank" href="http://twitter.com/%savecalgrants%/statuses/%id_str%/">%user_screen_name%</a>'
    });
  </script>

  <!-- for the instagram feed-->
  <!--
  <script 
    type="text/javascript" 
      src="<?php echo $ROOT ?>/javascripts/instagram-feed/jquery-1.6.2.min.js">
  </script>
  -->
  <script 
    type="text/javascript" 
      src="<?php echo $ROOT ?>/javascripts/instagram-feed/jquery.instagram.js">
  </script>

  <script type="text/javascript">
    // Instagram Extension 

    $(document).ready(function() {
      if ( $( window ).width() >= 768 ) {
        $(".instagram").instagram({
          hash: 'codesquire',
          show: '1',
          clientId: 'fab9eb6c02024f7a9c990f0fc5da187e'
        });
      } else {
        $(".instagram").instagram({
          hash: 'codesquire',
          show: '1',
          clientId: 'fab9eb6c02024f7a9c990f0fc5da187e'
        });

      }
    });

    $(window).load(function () {
      $('div.instagram-placeholder').each( function(i) {
        if( i % 4 != 3 )
        return $(this).addClass('last')
      })
    });
  </script>

<?PHP include 'foot.php'; ?>
