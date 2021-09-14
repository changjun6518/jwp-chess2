package domain.piece;

import domain.board.Board;
import domain.direction.Direction;
import domain.moveStrategy.MoveStrategy;
import domain.moveStrategy.MultiMoveStrategy;
import domain.moveStrategy.PawnMoveStrategy;
import domain.moveStrategy.SingleMoveStrategy;
import domain.position.Position;

import java.util.List;

public enum PieceType {
    KING(new SingleMoveStrategy(Direction.getKingDirections())),
    QUEEN(new MultiMoveStrategy(Direction.getQueenDirections())),
    ROOK(new MultiMoveStrategy(Direction.getRookDirections())),
    KNIGHT(new SingleMoveStrategy(Direction.getKnightDirections())),
    BISHOP(new MultiMoveStrategy(Direction.getBishopDirections())),
    WHITE_PAWN(new PawnMoveStrategy(Direction.getFirstWhitePawnDirections())),
    BLACK_PAWN(new PawnMoveStrategy(Direction.getFirstBlackPawnDirections())),
    NONE(new SingleMoveStrategy(Direction.getNoneDirections())),;

    private final MoveStrategy moveStrategy;

    PieceType(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<Position> getPossiblePaths(Position from, Board board) {
        return moveStrategy.possiblePositions(from, board);
    }
}
