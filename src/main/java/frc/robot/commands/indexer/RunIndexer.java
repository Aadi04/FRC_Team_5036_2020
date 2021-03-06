package frc.robot.commands.indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;


public class RunIndexer extends CommandBase {
    private final Indexer indexer;
    private final Shooter shooter;
    private final double RPM_TO_RUN_INDEXER = 7000;
    private double startTime;
    private boolean isRunningBackwards;
    private final double timeRunningForward = 500;
    private final double timeRunningBackward = 100;
    private final double clockCycle = timeRunningBackward + timeRunningForward;


    public RunIndexer(Indexer indexer, Shooter shooter) {
        this.indexer = indexer;
        this.shooter = shooter;
        addRequirements(indexer);
    }

    @Override
    public void initialize()
    {
        startTime = System.currentTimeMillis();
        isRunningBackwards = false;
    }

    @Override
    public void execute()
    {
        if(shooter.getRPM() > RPM_TO_RUN_INDEXER )
        {
            indexer.runIndexer(0.6,0.5,0.5);
        }
        else
        {
            indexer.stopIndexer();
        }
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        indexer.stopIndexer();
    }
}
