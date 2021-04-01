<#import "/spring.ftl" as spring>

<#import "partials/main.ftlh" as main/>

<@main.renderWith>

    <div class="container">
        <div class="card-group">
            <div class="row-4">
                <#list foods as food>
                    <div class="col">
                        <div class="card">
                            <img src=${food.food.image} class="card-img-top" alt="${food.food.name}">
                            <div class="card-body">
                                <h5 class="card-title">${food.food.name}</h5>
                                <p class="card-text">${food.food.description}</p>
                                <p class="card-text">${food.food.gram} <@spring.message "Gram"/></p>
                                <p class="card-text">${food.food.price} <@spring.message "Som"/></p>
                                <p class="card-text">${food.food.quantity}<@spring.message"Qty"/> </p>
                                <p class="card-text">${food.food.type.name} <@spring.message"Type"/></p>
                            </div>
                            <form action="/basket/delete" method="post">

                                <#if _csrf??>
                                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                           value="${(_csrf.token)!'--no-token--'}"/>
                                </#if>
                                <div>
                                    <input type="hidden" name="foodId" value="${food.food.id}">
                                    <button type="submit"><@spring.message "DeletefromBasket"/></button>
                                </div>
                            </form>
                        </div>
                    </div>
                </#list>
            </div>
        </div>

        <div class="card">
            <form action="/basket/order" method="post" style="text-align: center; justify-content: center">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                           value="${(_csrf.token)!'--no-token--'}"/>
                </#if>

                <div>
                    <label class="flex flex-v-center">
                        <p class="label-input-text"><@spring.message "Ordering"/></p>
                        <input type="text" name="name" placeholder=<@spring.message"Your-name"/> value="${(form.name)!''}">
                    </label>
                </div>
                <div>
                    <label class="flex flex-v-center">
                        <input type="text" name="address" placeholder=<@spring.message"Your-Email"/> value="${(form.address)!''}">
                    </label>
                </div>
                <div>
                    <label class="flex flex-v-center">
                        <input type="text" name="tel" placeholder=<@spring.message"Your-phone-Number"/> value="${(form.tel)!''}">
                    </label>
                </div>
                <p><@spring.message"Total"/> : ${form.total} <@spring.message"Som"/> </p>
                <div>
                    <input type="hidden" name="total" value="${form.total}">
                    <button type="submit"><@spring.message"Order"/></button>
                </div>
            </form>
        </div>
    </div>
</@main.renderWith>