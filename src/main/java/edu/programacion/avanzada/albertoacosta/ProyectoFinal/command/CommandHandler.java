package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
