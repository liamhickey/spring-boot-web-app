function createBuddy (e) {
    e.preventDefault();
    $.ajax({
        type: "POST",
        url: "http://localhost:8090/addressBook",
        data: $("#buddyForm").serializeArray(),
        dataType: "json"
    }).then(function(data) {
        $("#tableBuddies").append("asdfasdfasdfsadfsdadf");
    });
}