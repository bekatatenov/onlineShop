<#import "/spring.ftl" as spring>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/login.css">
    <title>Sishi bar</title>
</head>
<body>

<div class="login-page">
    <div class="form">
        <form class="login-form" action="/user/register" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <input type="text" name="name" placeholder="ваше имя" value="${(form.name)!''}">
            <input type="text" name="email" placeholder="ваш адрес почты" value="${(form.email)!''}">
            <input type="text" name="password" placeholder="пароль" value="">
            <button>create</button>
            <p class="message">Already registered? <a href="/user/login">Sign In</a></p>
            <p class="message">Main Page? <a href="/">Main Page</a></p>
        </form>
    </div>
</div>
<script src="/js/login.js"></script>
</body>
</html>