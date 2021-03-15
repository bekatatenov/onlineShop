<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="container">
    <div class="register-block">
        <div class="reg-header">
            <div>Регистрация</div>
        </div>
        <div class="reg-body">
            <form action="/user/register" method="post">
                <div class="reg-elements">
                    <label for="field-1" class="field-label">Имя</label>
                    <input type="text" id="field-1" class="field-input" name="name">
                </div>
                <div class="reg-elements">
                    <label for="field-2" class="field-label">Емайл</label>
                    <input type="email" id="field-2" class="field-input" name="email">
                </div>
                <div class="reg-elements">
                    <label for="field-4" class="field-label">Пароль</label>
                    <input type="password" id="field-4" class="field-input" name="password">
                    <label for="field-4-1" class="passwordCheckbox">Показать Пароль<input type="checkbox"
                                                                                          id="field-4-1"></label>
                </div>
                <div class="reg-elements">
                    <button type="submit" class="button">Создать</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>