

<body>
    
    <h1>Advanced Calculator</h1>
    <input type="text" id="display" readonly>
    <br>
    <button onclick="addToDisplay('7')">7</button>
    <button onclick="addToDisplay('8')">8</button>
    <button onclick="addToDisplay('9')">9</button>
    <button onclick="addToDisplay('+')">+</button>
    <br>
    <button onclick="addToDisplay('4')">4</button>
    <button onclick="addToDisplay('5')">5</button>
    <button onclick="addToDisplay('6')">6</button>
    <button onclick="addToDisplay('-')">-</button>
    <br>
    <button onclick="addToDisplay('1')">1</button>
    <button onclick="addToDisplay('2')">2</button>
    <button onclick="addToDisplay('3')">3</button>
    <button onclick="addToDisplay('*')">*</button>
    <br>
    <button onclick="addToDisplay('0')">0</button>
    <button onclick="addToDisplay('.')">.</button>
    <button onclick="calculate()">=</button>
    <button onclick="addToDisplay('/')">/</button>
    <br>
    <button onclick="addToDisplay('Math.sqrt(')">√</button>
    <button onclick="addToDisplay('**')">^</button>
    <button onclick="clearDisplay()">C</button>

    <script>
        function addToDisplay(value) {
            document.getElementById('display').value += value;
        }

        function calculate() {
            const displayValue = document.getElementById('display').value;
            try {
                const result = Function(`'use strict'; return (${displayValue});`)();
                document.getElementById('display').value = result;
            } catch (error) {
                document.getElementById('display').value = 'Error';
            }
        }

        function clearDisplay() {
            document.getElementById('display').value = '';
        }
    </script>
</body>
</html>
