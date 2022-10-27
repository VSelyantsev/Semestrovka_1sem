<html>
<#include "base.ftl">
<head>
	<meta charset="utf-8">
	<title>Planets</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Kanit:wght@300&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://bootstraptema.ru/plugins/2016/animate/animate.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styleForPlanets.css">

</head>
<body>


	<div class="container">
		 <div class="row">
		 <div id="carousel-example-generic" class="carousel slide carousel-fade carousel-animate carousel-bg" data-ride="carousel">
			 <!-- Indicators -->
			 <ol class="carousel-indicators">
				 <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				 <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				 <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			 </ol>
			 <!-- Wrapper for slides -->
			 <div class="carousel-inner" role="listbox">
				 <div class="item active" style="background-image: url(images/planets/firstSlide.jpg)">
					 <div class="carousel-caption">
						 <div class="hero">
							<hgroup class="zoomInDown animated">
								<h1 class="fadeInLeft animated">Solar System</h1>
							</hgroup>
						 </div>
					 </div>
				 </div>
				 <div class="item" style="background-image: url(images/planets/secondSLide.jpg)">
					 <div class="carousel-caption">
						 <div class="hero fadeInUp animated">
							 <hgroup>
							 	<h1>Solar System</h1>
							 </hgroup>
						 </div>
					 </div>
				 </div>

				 <div class="item" style="background-image: url(images/planets/thirdSlide.jpg)">
					 <div class="carousel-caption">
						 <div class="hero rollIn animated">
							 <hgroup class="rotateInDownRight animated">
							 	<h1>Solar System</h1>
							 </hgroup>
						 </div>
					 </div>
				 </div>

			 <!-- Controls -->
			 <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			 <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			 <span class="sr-only">Назад</span>
			 </a>
			 <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			 <span class="sr-only">Вперёд</span>
			 </a>
		 </div>

		</div>
	</div>

	<!-- Navigation -->
	<div class="wrapper-of-list">
		<h3 class="navigation">Navigation</h3>
		<div class="wrapper-northen">
				<div class="zodiacNorthern">
					<button class="buttonForNavigation">
						<a class="hrefForNavigation" href="#mercuryDectroption">Mercury</a>
					</button>
				</div>
				<div class="zodiacNorthern">
					<button class="buttonForNavigation">
						<a class="hrefForNavigation" href="#venusDectroption">Venus</a>
					</button>
				</div>
				<div class="zodiacNorthern">
					<button class="buttonForNavigation">
						<a class="hrefForNavigation" href="#earthDectroption">Earth</a>
					</button>
				</div>
				<div class="zodiacNorthern">
					<button class="buttonForNavigation">
						<a class="hrefForNavigation" href="#marsDectroption">Mars</a>
					</button>
				</div>
		</div>

		<div class="wrapper-southern">
			<div class="zodiacSouthern">
				<button class="buttonForNavigation">
					<a class="hrefForNavigation" href="#jupiterDectroption">Jupiter</a>
				</button>
			</div>
			<div class="zodiacSouthern">
				<button class="buttonForNavigation">
					<a class="hrefForNavigation" href="#saturnDectroption">Saturn</a>
				</button>
			</div>
			<div class="zodiacSouthern">
				<button class="buttonForNavigation">
					<a class="hrefForNavigation" href="#uranusiusiDectroption">Uranus</a>
				</button>
			</div>
			<div class="zodiacSouthern">
				<button class="buttonForNavigation">
					<a class="hrefForNavigation" href="#neptuneDectroption">Neptune</a>
				</button>
			</div>
			</div>
		</div>
	</div>

	<div class="mainPart">
		<h3 class="planetName" id="mercuryDectroption">Mercury</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/mercury.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">Mercury is the smallest planet in the solar system and the closest to the sun. Named after the ancient Roman god of trade, Mercury is fast because it moves through the sky faster than other planets. Its period of revolution around the Sun is only 87.97 Earth days - the shortest among all the planets in the solar system.</p>
			</div>
		</div>

		<h3 class="planetName" id="venusDectroption">Venus</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/venera.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">Venus is the second farthest from the Sun and the sixth largest planet in the solar system, along with Mercury, Earth and Mars, belonging to the family of terrestrial planets. Named after the ancient Roman goddess of love, Venus. According to a number of characteristics - for example, in mass and size - Venus is considered the "sister" of the Earth.</p>
			</div>
		</div>

		<h3 class="planetName" id="earthDectroption">Earth</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/earth.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">
				Earth is the third planet from the Sun in the solar system. The densest, fifth in diameter and mass among all the planets of the solar system and the largest among the terrestrial planets, which also includes Mercury, Venus and Mars.</p>
			</div>
		</div>	

		<h3 class="planetName" id="marsDectroption">Mars</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/mars.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">
					Mars is a terrestrial planet with a rarefied atmosphere (the pressure on the surface is 160 times less than that of the earth). The features of the surface relief of Mars can be considered impact craters like those of the moon, as well as volcanoes, valleys, deserts and polar ice caps like those of the earth.</p>
			</div>
		</div>

		<h3 class="planetName" id="jupiterDectroption">Jupiter</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/jupiter.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">Jupiter is the largest planet in the solar system, a gas giant. Its equatorial radius is 71.4 thousand km, which is 11.2 times the radius of the Earth. Jupiter is the only planet whose center of mass with the Sun is outside the Sun and is about 7% of the solar radius from it.</p>
			</div>
		</div>
	<h3 class="planetName" id="saturnDectroption">Saturn</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/saturn.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">Saturn belongs to the type of gas planets: it consists mainly of gases and does not have a solid surface. The equatorial radius of the planet is 60,300 km, the polar radius is 54,400 km; Of all the planets in the solar system, Saturn has the most compression.</p>
			</div>
		</div>	

		<h3 class="planetName" id="uranusiusiDectroption">Uran</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/uran.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">Uranus is the planet of the solar system, the seventh in distance from the Sun, the third in diameter and the fourth in mass. It was discovered in 1781 by the English astronomer William Herschel and named after the Greek sky god Uranus.</p>
			</div>
		</div>

		<h3 class="planetName" id="neptuneDectroption">Neptune</h3>
		<div class="part">
			<div class="img-left">
				<img class="picture-properties" 
					src="images/planets/mainContent/neptune.jpg">
			</div>
			<div class="description-right">
				<p class="paragraph-properties">Neptune is the eighth and farthest planet from the Sun in the solar system. Its mass exceeds the mass of the Earth by 17.2 times and is the third among the planets of the solar system, and in terms of equatorial diameter, Neptune ranks fourth, surpassing the Earth by 3.9 times. The planet is named after Neptune, the Roman god of the seas.</p>
			</div>
		</div>
	</div>

</body>
</html>