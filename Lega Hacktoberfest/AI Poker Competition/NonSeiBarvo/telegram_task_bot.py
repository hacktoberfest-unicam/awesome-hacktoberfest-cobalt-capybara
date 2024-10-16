from concurrent.futures import ThreadPoolExecutor

import datetime

import asyncio
from telegram import Update
from telegram.ext import Application, CommandHandler, ContextTypes, CallbackContext, MessageHandler, filters


class Task:
    title: str
    description: str
    date: str

    def __init__(self, title: str, description: str, date: datetime.datetime):
        self.title = title
        self.description = description
        self.date = date


tasks = []


async def handle_message(update: Update, context: ContextTypes.DEFAULT_TYPE) -> None:
    title, desc, date = update.message.text.lower().split(",")
    datetime_object = datetime.datetime.strptime(date, '%d/%m/%y %H:%M:%S')
    task = Task(title, desc, datetime_object)
    tasks.append(task)
    print(len(tasks))
    await update.message.reply_text(f"{title=}, {desc=}, {date=} saved")



async def create_task(update: Update, context: ContextTypes.DEFAULT_TYPE):
    await update.message.reply_text(
        "Bene! scrivi la task separato da virgola come:\nfare la spesa,pasta;pane;pomodoro,09/19/22 13:55:26")

def check_datetime(context):
    for task in tasks:
        while True:
            now = datetime.datetime.now()
            if now >= task.date:
                context.bot.send_message(chat_id=context.job.context, text=f"{task.title}, {task.description}, {task.date}")
                break


async def start_command(update: Update, context: CallbackContext) -> None:
    await update.message.reply_text(
        "Ciao HacktoberFest! Anche se dovete fare le challenge, volete programmarvi qualche task da fare dopo? crivi '/createtask'")

    # asyncio.create_task(check_datetime(context))

if __name__ == '__main__':
    app = Application.builder().token("7839866313:AAH0zy8BIZ-pNaKW4olaTtgrfM8cruUIFAw").build()

    app.add_handler(CommandHandler("start", start_command))
    app.add_handler(CommandHandler("createtask", create_task))

    app.add_handler(MessageHandler(filters.TEXT, handle_message))


    print("polling")
    app.run_polling(poll_interval=3)

    # CONFLICTS
    # with ThreadPoolExecutor(max_workers=1) as executor:
    #     executor.submit(check_datetime)
