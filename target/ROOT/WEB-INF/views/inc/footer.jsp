<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<footer class="footer mt-auto">
  <div class="copyright bg-white">
    <p>
      &copy; <span id="copy-year"></span> Copyright by Our Project.
    </p>
  </div>
  <script>
    var d = new Date();
    var year = d.getFullYear();
    document.getElementById("copy-year").innerHTML = year;
  </script>
</footer>