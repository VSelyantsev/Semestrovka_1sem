<html lang="en">
<#include "base.ftl">
<head>
    <meta charset="utf-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.transitions.css"> 
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
    <script>
      $(document).ready(function(){
        $("#testimonial-slider").owlCarousel({
          items:1,
          itemsDesktop:[1000,1],
          itemsDesktopSmall:[979,1],
          itemsTablet:[767,1],
          pagination:false,
          transitionStyle:"fade",
          navigation:true,
          navigationText:["",""],
          autoPlay:true
        });
      });
    </script>
    <link rel="stylesheet" type="text/css" href="styleForMainPage.css">
</head>
<body>
<#macro content>
  <div class="intro-section">
    <div class="intro-content">
      <div class="intro-container">
        <div class="intro-header">
        <h2>Introduction</h2>
        <h1 class="section-title">Astrology</h1>
      </div>

      <div class="intro-body">
        <div class="intro-left">
          <p>- a unique system of cognition of the Cosmos, human nature in their evolutionary movement.</p>
        </div>
        <div class="intro-right">
          <p>Since ancient times, people have used star charts to predict their fate. Nowadays, thanks to the latest observation technologies, we can know exactly the location of celestial bodies and their influence on the NSF.</p>
        </div>
      </div>
      </div>
    </div>
  </div>



  <div class="container">
    <div class="row">
      <div class="col-md-offset-2 col-md-8">
        <div id="testimonial-slider" class="owl-carousel">
          <div class="testimonial">
             <div class="pic"></div>
               <p class="description">
               "Astrology is like a deep ocean - you can't reach the bottom. But to dive deeper and become wiser, having absorbed at least a few drops of true knowledge, everyone can do it."
               </p>
          </div>
           
           <div class="testimonial">
             <div class="pic"></div>
               <p class="description">
                  "To sail the sea of life there is no better ship than a horoscope."
               </p>
           </div>

             <div class="testimonial">
              <div class="pic"></div>
               <p class="description">
                "Anyone can become a millionaire, but if you want to make billions, you need an astrologer."
               </p>
           </div>
          </div>
        </div>
      </div>
  </div>

</#macro>
</body>
</html>


 