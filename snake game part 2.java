const gameBoard = document.getElementById('game-board');
const snake = document.getElementById('snake');
const food = document.getElementById('food');

const gridSize = 20;
const gridRows = gameBoard.clientHeight / gridSize;
const gridCols = gameBoard.clientWidth / gridSize;

let snakeX = 10;
let snakeY = 10;
let snakeSpeedX = 1;
let snakeSpeedY = 0;
const snakeBody = [{ x: snakeX, y: snakeY }];

let foodX = 5;
let foodY = 5;

let score = 0;

function updateGame() {
    snakeX += snakeSpeedX;
    snakeY += snakeSpeedY;

    if (snakeX < 0 || snakeX >= gridCols || snakeY < 0 || snakeY >= gridRows) {
        gameOver();
        return;
    }

    for (let i = 1; i < snakeBody.length; i++) {
        if (snakeX === snakeBody[i].x && snakeY === snakeBody[i].y) {
            gameOver();
            return;
        }
    }

    if (snakeX === foodX && snakeY === foodY) {
        score++;
        generateFood();
        snakeBody.push({});
    }

    snakeBody[0].x = snakeX;
    snakeBody[0].y = snakeY;

    for (let i = snakeBody.length - 1; i >= 1; i--) {
        snakeBody[i].x = snakeBody[i - 1].x;
        snakeBody[i].y = snakeBody[i - 1].y;
    }

    drawGame();
    setTimeout(updateGame, 100);
}

function drawGame() {
    snake.style.left = snakeX * gridSize + 'px';
    snake.style.top = snakeY * gridSize + 'px';

    for (let i = 1; i < snakeBody.length; i++) {
        const bodyPart = document.createElement('div');
        bodyPart.className = 'snake-body';
        bodyPart.style.left = snakeBody[i].x * gridSize + 'px';
        bodyPart.style.top = snakeBody[i].y * gridSize + 'px';
        gameBoard.appendChild(bodyPart);
    }

    while (gameBoard.childElementCount > snakeBody.length + 1) {
        gameBoard.removeChild(gameBoard.lastChild);
    }

    food.style.left = foodX * gridSize + 'px';
    food.style.top = foodY * gridSize + 'px';
}

function generateFood() {
    foodX = Math.floor(Math.random() * gridCols);
    foodY = Math.floor(Math.random() * gridRows);
}

function gameOver() {
    alert('Game Over! Your Score: ' + score);
    location.reload(); // Restart the game
}

document.addEventListener('keydown', (event) => {
    switch (event.key) {
        case 'ArrowUp':
            if (snakeSpeedY !== 1) {
                snakeSpeedX = 0;
                snakeSpeedY = -1;
            }
            break;
        case 'ArrowDown':
            if (snakeSpeedY !== -1) {
                snakeSpeedX = 0;
                snakeSpeedY = 1;
            }
            break;
        case 'ArrowLeft':
            if (snakeSpeedX !== 1) {
                snakeSpeedX = -1;
                snakeSpeedY = 0;
            }
            break;
        case 'ArrowRight':
            if (snakeSpeedX !== -1) {
                snakeSpeedX = 1;
                snakeSpeedY = 0;
            }
            break;
    }
});

generateFood();
updateGame();
