package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
