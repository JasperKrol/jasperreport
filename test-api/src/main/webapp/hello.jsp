<!DOCTYPE html>
<html>
<head>
    <title>Spring Web Application</title>
</head>
<body>
<h1>Welcome to Spring Web Application</h1>
<p>Try accessing <a href="hello">/hello</a> to see the controller response.</p>
<hr>
<h2>Hello from JSP file!</h2>
<p>This content is served by Spring MVC and JSP.</p>

<div id="pdfPreview">
    <!-- Placeholder for PDF preview -->
</div>

<!-- JavaScript to fetch and display PDF content -->
<script>
    // Function to fetch and display PDF content
    function loadPdfPreview() {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', '/spring_web_app_war/api/generate', true);
        xhr.responseType = 'blob';

        xhr.onload = function() {
            if (this.status === 200) {
                var blob = this.response;
                var url = URL.createObjectURL(blob);

                // Display PDF using <embed> tag
                var embed = document.createElement('embed');
                embed.setAttribute('src', url);
                embed.setAttribute('type', 'application/pdf');
                embed.setAttribute('width', '100%');
                embed.setAttribute('height', '600px'); // Adjust height as needed
                document.getElementById('pdfPreview').appendChild(embed);
            } else {
                console.error('Error loading PDF:', this.status, this.statusText);
            }
        };

        xhr.onerror = function() {
            console.error('Network error while fetching PDF');
        };

        xhr.send();
    }

    // Call the function when the page loads
    loadPdfPreview();
</script>
</body>
</html>
