<#import "/spring.ftl" as spring>
<#macro renderWith title="Sushi Bar" dir="ltr" scripts=[] styles=[]>

    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
              crossorigin="anonymous">
        <link rel="stylesheet" href="/css/style.css">

        <link rel="stylesheet" href="/fonts/14362.ttf">
        <script src="https://kit.fontawesome.com/074becbd45.js" crossorigin="anonymous"></script>
        <title>${title}</title>

        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
    </head>

    <body class="body">
    <header class="container">
        <div class="header">

            <div class="card" style="width: 18rem; text-align: center; background: inherit; border: none">
                <div class="card-body">
                    <div class="logo"><img src="/images/logo.svg" alt="logo"></div>
                </div>
            </div>
            <!--        Bishkek-->
            <div class="card" style="width: 18rem; text-align: center; background: inherit; border: none">
                <div class="card-body">
                    <div class="tel-head">
                        <div class="city"><h5 class="card-title cities">Бишкек</h5>
                        </div>
                        <div class="icon"><a href="https://wa.me/996502082222"><i class="fab fa-whatsapp icons"></i></a>
                        </div>
                    </div>
                    <div class="tel">
                        <div class="code">
                            <a href="tel:+996554082222">0 554/</a>
                            <a href="tel:+996774082222">0 774/</a>
                            <a href="tel:+996502082222">0 502</a>
                        </div>
                        <div class="number"><a href="tel:+996502082222">
                                08-22-22</a></div>
                    </div>
                </div>
            </div>

            <!--        Osh-->
            <div class="card" style="width: 18rem; text-align: center; background: inherit; border: none">
                <div class="card-body">
                    <div class="tel-head">
                        <div class="city"><h5 class="card-title cities">Ош</h5>
                        </div>
                        <div class="icon"><a href="https://wa.me/996556081111"><i class="fab fa-whatsapp icons"></i></a>
                        </div>
                    </div>
                    <div class="tel">
                        <div class="code">
                            <a href="tel:+996554081111">0 554/</a>
                            <a href="tel:+996774081111">0 774/</a>
                            <a href="tel:+996502081111">0 502</a>
                        </div>
                        <div class="number"><a href="tel:+996554081111">
                                08-11-11</a></div>
                    </div>
                </div>
            </div>


            <!--        D-abad-->
            <div class="card" style="width: 20rem; text-align: center; background: inherit; border: none">
                <div class="card-body">
                    <div class="tel-head">
                        <div class="city"><h5 class="card-title cities">Джалал-Абад </h5>
                        </div>
                        <div class="icon"><a href="https://wa.me/996554083333"><i class="fab fa-whatsapp icons"></i></a>
                        </div>
                    </div>
                    <div class="tel">
                        <div class="code">
                            <a href="tel:+996554083333">0 554/</a>
                            <a href="tel:+996774083333">0 774/</a>
                            <a href="tel:+996704083333">0 704</a>
                        </div>
                        <div class="number"><a href="tel:+996554083333">
                                08-33-33</a></div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="navigation">
        <nav class="navbar navbar-expand-lg" style="background: #bfa58c;">
            <ul class="navbar-nav me-auto mx-auto">
                <li class="nav-item" style="padding-right: 10px">
                    <button class="btn btn-primary"><a style="color: black" href="/">Home</a></button>
                </li>
                <li>
                    <form class="row g-4" style="justify-content: center" id="form-id">
                        <div class="col-auto">
                            <input type="text" class="form-control" name="text" id="input"
                                   placeholder="search" onfocus="this.value=''" autofocus>
                        </div>
                        <div class="col-auto">
                            <select class="form-select" name="param" aria-label="Default select example">
                                <option value="name">Name</option>
                                <option value="type">Type</option>
                                <option value="desc">Description</option>
                            </select>
                        </div>
                        <div class="col-auto">
                            <button type="submit" formaction="/found" class="btn btn-primary mb-3">Search</button>
                        </div>
                    </form>
                </li>

                <li style="padding-left: 10px">
                    <div>
                        <#if user??>
                            <button class="btn btn-primary"><a style="color: black" href="/basket">Basket</a></button>
                            <button class="btn btn-primary"><a style="color: black" href="/user/profile">${(user.userName)!'-- missing --'} - ${(user.email)!'-- email missing --'}</a></button>
                        <#else>
                            <button class="btn btn-primary"><a style="color: black" href="/user/login">LogIn</a>
                            </button>
                        </#if>
                    </div>
                </li>
                <li style="padding-left: 10px">
                    <#if user??>
                    <form action="/logout" method="post">

                        <#if _csrf??>
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                   value="${(_csrf.token)!'--no-token--'}"/>
                        </#if>
                        <button class="btn btn-primary" type="submit">LogOut</button>
                    </form>
                    </#if>
                </li>

            </ul>
        </nav>
    </div>

    <main>
        <#nested>
    </main>

    <#list scripts as scriptSource>
        <script src="${scriptSource}"></script>
    </#list>
    </body>
    </html>
</#macro>