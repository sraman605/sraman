
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Contact Us</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href='style.css' type='text/css' media='all' />
</head>
<body>
<div id="central">
    <div class="content">
        <h1>Contact Form</h1>
        <p>Send your comments through this form and we will get back to
            you.</p>
        <div id="message">
            <form id="frmContact" name="frmContact" action="" method="POST"
                  novalidate="novalidate">
                <div class="label">Name:</div>
                <div class="field">
                    <input type="text" id="pp-name" name="name"
                           placeholder="enter your name here" title="Please enter your name"
                           class="required" aria-required="true" required>
                </div>
                <div class="label">Email:</div>
                <div class="field">
                    <input type="text" id="pp-email" name="email"
                           placeholder="enter your email address here"
                           title="Please enter your email address" class="required email"
                           aria-required="true" required>
                </div>
                <div class="label">Phone Number:</div>
                <div class="field">
                    <input type="text" id="pp-phone" name="phone"
                           placeholder="enter your phone number here"
                           title="Please enter your phone number" class="required phone"
                           aria-required="true" required>
                </div>
                <div class="label">Message:</div>
                <div class="field">
						<textarea id="about-project" name="message"
                                  placeholder="enter your message here"></textarea>
                </div>
                <div id="mail-status"></div>
                <input type="submit" name="submit" value="Send Message"
                       id="send-message" style="clear: both;">

            </form>
        </div>
    </div>
    <!-- content -->
</div>
<!-- central -->
</body>
</html>