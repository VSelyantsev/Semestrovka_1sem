<html lang="en">
<head>
    <meta charset="UTF-8">
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
    <style>
        nav {
            background: linear-gradient(91.1deg, rgb(57, 31, 105) -2.3%, rgb(115, 43, 155) 44.4%, rgb(231, 75, 184) 103.4%);
        }

        .navbar-brand {
            margin-top: 23px;
            font-size: 20px;
            text-align: center;
        }

        .collapse {
            font-size: 18px;
        }

        .buttonFroSearch {
            border-radius: 30px;
            background: linear-gradient(49.14deg,#9b4fde 18.31%,#9465e6 41.08%,#4536d6 100.46%);
            color: white;
            border: 0;
        }

        .eyeLogo {
            width: 50px;
            height: auto;
            margin-left: 30px;
        }
    </style>

    <header>
        <nav class="navbar navbar-expand-lg navbar-light">
            <picture>
                <img  class="eyeLogo" src="images/mainLogo/Logo.png">
            </picture>
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/Astrology_war_exploded/zodiacs">Zodiac Signs</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="/Astrology_war_exploded/planets">Planets</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="">Articles</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link active dropdown-toggle" href="/profile" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">
                                Menu
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="/Astrology_war_exploded/profile">Profile</a></li>
                                <li><a class="dropdown-item" href="/Astrology_war_exploded/articles">My articles</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="/Astrology_war_exploded/login">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form method="post" action="mainPage" class="d-flex">
                        <input class="form-control me-2" name="request" type="search" placeholder="Enter something" aria-label="Search">
                        <button class="buttonFroSearch" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>
</head>

<body>


<div class="content1">
    <div class="content"><@content></@content></div>
</div>


</body>
</html>